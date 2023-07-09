package com.cdw.eatz.customer.controller;

import com.cdw.eatz.common.response.ApiResponse;
import com.cdw.eatz.common.response.custom.SaveOrLoginCustomerResponse;
import com.cdw.eatz.customer.entity.Customer;
import com.cdw.eatz.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.cdw.eatz.common.constant.EndPointConstant.CUSTOMER;
import static com.cdw.eatz.common.constant.EndPointConstant.CUSTOMER_LOGIN;
import static com.cdw.eatz.common.constant.ResponseMessageConstant.CUSTOMER_LOGGED_IN_SUCCESS;
import static com.cdw.eatz.common.constant.ResponseMessageConstant.CUSTOMER_LOGGED_IN_SUCCESS_CODE;
import static com.cdw.eatz.common.constant.ResponseMessageConstant.SAVE_CUSTOMER_MESSAGE;
import static com.cdw.eatz.common.constant.ResponseMessageConstant.SAVE_CUSTOMER_MESSAGE_CODE;

/**
 * A Spring REST Controller that performs customer operations.
 *
 * @author somukumar.ekambaram
 * @version 0.0.1-SNAPSHOT
 * @since May 2023
 */
@RestController
@RequestMapping(value = CUSTOMER)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Method to call save customer operations.
     *
     * @param customer { Customer }
     * @throws Exception {*}
     * @return {*}
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<SaveOrLoginCustomerResponse> saveCustomer(@RequestBody Customer customer) throws Exception {

        SaveOrLoginCustomerResponse saveCustomer = this.customerService.saveCustomer(customer);

        return new ApiResponse<>(true, SAVE_CUSTOMER_MESSAGE_CODE, SAVE_CUSTOMER_MESSAGE, saveCustomer);
    }

    @PostMapping(value = CUSTOMER_LOGIN)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<SaveOrLoginCustomerResponse> loginCustomer(@RequestParam String email, @RequestParam String password) {

        SaveOrLoginCustomerResponse loggedInCustomer = this.customerService.loginCustomer(email, password);

        return new ApiResponse<>(true, CUSTOMER_LOGGED_IN_SUCCESS_CODE, CUSTOMER_LOGGED_IN_SUCCESS,loggedInCustomer);
    }

}
