package com.cdw.eatz.customer.service.impl;

import com.cdw.eatz.common.exception.CustomerAuthenticationFailedException;
import com.cdw.eatz.common.exception.CustomerExistException;
import com.cdw.eatz.common.exception.CustomerNotFoundException;
import com.cdw.eatz.common.response.custom.SaveOrLoginCustomerResponse;
import com.cdw.eatz.common.util.jwt.JsonWebTokenUtil;
import com.cdw.eatz.customer.entity.Customer;
import com.cdw.eatz.customer.helper.GlobalCustomerServiceHelper;
import com.cdw.eatz.customer.repository.CustomerRepository;
import com.cdw.eatz.customer.service.CustomerService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.cdw.eatz.common.constant.ResponseMessageConstant.CUSTOMER_AUTHENTICATION_FAILED;
import static com.cdw.eatz.common.constant.ResponseMessageConstant.CUSTOMER_NOT_FOUND;

/**
 * CustomerServiceImpl.java
 * A Spring Service class that performs customer operations.
 *
 * @author somukumar.ekambaram
 * @since May 2023
 * @version 0.0.1-SNAPSHOT
 */
@Service
@NoArgsConstructor
public class CustomerServiceImpl extends GlobalCustomerServiceHelper implements CustomerService {

    private static final CustomerServiceImpl customerServiceHelper = new CustomerServiceImpl();

    private CustomerRepository customerRepository;
    private JsonWebTokenUtil jsonWebTokenUtil;

    @Autowired
    CustomerServiceImpl(
            CustomerRepository customerRepository,
            JsonWebTokenUtil jsonWebTokenUtil) {
        this.customerRepository = customerRepository;
        this.jsonWebTokenUtil = jsonWebTokenUtil;
    }

    /**
     * Method to save customer
     *
     * @param customer { Customer }
     * @throws Exception {*}
     * @return { Customer }
     */
    @Override
    public SaveOrLoginCustomerResponse saveCustomer(Customer customer) throws Exception {

        String username = customerServiceHelper.generateUsername(customer.getEmail());
        customer.setUsername(username);
        customer.setProfileVerified(false);

        // validates customer if already exist.
        validateCustomerByEmailOrPhoneNumber(customer.getEmail(), customer.getPhoneNumber());

        try {

            Customer savedCustomer = customerRepository.save(customer);

            // generate json web token for user
            String jwtToken = jsonWebTokenUtil.generateJsonWebToken(savedCustomer);

            SaveOrLoginCustomerResponse saveCustomerResponse = new SaveOrLoginCustomerResponse();
            saveCustomerResponse.setCustomerId(savedCustomer.getCustomerId());
            saveCustomerResponse.setUsername(savedCustomer.getUsername());
            saveCustomerResponse.setEmail(savedCustomer.getEmail());
            saveCustomerResponse.setBearerToken(jwtToken);

            return saveCustomerResponse;

        } catch (CustomerExistException customerExistException) {
            throw customerExistException;
        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }

    /**
     * Method to authenticate the customer
     *
     * @param email    {String}
     * @param password {String}
     * @return loginCustomerResponse {SaveOrLoginCustomerResponse}
     */
    @Override
    public SaveOrLoginCustomerResponse loginCustomer(String email, String password) {
        SaveOrLoginCustomerResponse loginCustomerResponse = new SaveOrLoginCustomerResponse();
        boolean isCustomerExist = customerRepository.existsByEmailIgnoreCaseOrPhoneNumber(email, null);
        if (isCustomerExist) {
            if (email != null && password != null) {
                Customer customer = customerRepository.findOneByEmailIgnoreCaseAndPassword(email, password);
                if(customer != null) {
                    // generate JWT
                    String token = jsonWebTokenUtil.generateJsonWebToken(customer);
                    loginCustomerResponse.setCustomerId(customer.getCustomerId());
                    loginCustomerResponse.setUsername(customer.getUsername());
                    loginCustomerResponse.setEmail(customer.getEmail());
                    loginCustomerResponse.setBearerToken(token);
                } else {
                    throw new CustomerAuthenticationFailedException(CUSTOMER_AUTHENTICATION_FAILED);
                }
            }
        } else {
            throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);
        }
        return loginCustomerResponse;
    }


}
