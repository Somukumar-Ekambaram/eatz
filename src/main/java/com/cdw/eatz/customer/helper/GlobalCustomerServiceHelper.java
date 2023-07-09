package com.cdw.eatz.customer.helper;

import com.cdw.eatz.common.exception.CustomerExistException;
import com.cdw.eatz.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.cdw.eatz.common.constant.ResponseMessageConstant.CUSTOMER_ALREADY_EXIST_BY_EMAIL_MESSAGE;
import static com.cdw.eatz.common.constant.ResponseMessageConstant.CUSTOMER_ALREADY_EXIST_BY_PHONE_NUMBER_MESSAGE;

/**
 * A Java Class contains common functionalities.
 *
 * @author somukumar.ekambaram
 * @version 0.0.1-SNAPSHOT
 * @since May 2023
 */
public class GlobalCustomerServiceHelper {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Method to creates a new username with customer email
     *
     * @param customerEmail {String}
     * @return username {String}
     */
    protected String generateUsername(String customerEmail) {
        String username = customerEmail.split("@")[0].toLowerCase();
        return username;
    }

    /**
     * Method to Validate Email or Phone Number is Exist in DB
     *
     * @param email {String}
     * @param phoneNumber {Long}
     */
    protected void validateCustomerByEmailOrPhoneNumber(String email, Long phoneNumber) {

        boolean isExistByEmail = false;
        boolean isExistByPhoneNumber = false;
        if (email != null) {
            isExistByEmail = customerRepository.existsByEmailIgnoreCaseOrPhoneNumber(email, null);
        }

        if (phoneNumber != null) {
            isExistByPhoneNumber = customerRepository.existsByEmailIgnoreCaseOrPhoneNumber(null, phoneNumber);
        }

        if (isExistByEmail) {
            throw new CustomerExistException(CUSTOMER_ALREADY_EXIST_BY_EMAIL_MESSAGE);
        } else if (isExistByPhoneNumber) {
            throw new CustomerExistException(CUSTOMER_ALREADY_EXIST_BY_PHONE_NUMBER_MESSAGE);
        }
    }
}
