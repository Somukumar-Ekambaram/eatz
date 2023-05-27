package com.cdw.eatz.customer.service;

import com.cdw.eatz.common.response.custom.SaveOrLoginCustomerResponse;
import com.cdw.eatz.customer.entity.Customer;

public interface CustomerService {


    /**
     * Method to save customer
     *
     * @param customer
     * @return { Customer }
     */
    SaveOrLoginCustomerResponse saveCustomer(Customer customer) throws Exception;

    /**
     * Method to authenticate the customer
     *
     * @param email {String}
     * @param password {String}
     * @return loginCustomerResponse {SaveOrLoginCustomerResponse}
     */
    SaveOrLoginCustomerResponse loginCustomer(String email, String password);
}
