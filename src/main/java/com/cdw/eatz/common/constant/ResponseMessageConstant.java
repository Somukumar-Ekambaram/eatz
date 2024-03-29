package com.cdw.eatz.common.constant;

/**
 * ResponseMessageConstant.java
 * A Java Constant Class
 *
 * @author somukumar.ekambaram
 * @since May 2023
 * @version 0.0.1-SNAPSHOT
 */
public class ResponseMessageConstant {

    /* Common Errors */

    public static final String SOMETHING_WENT_WRONG_CODE = "INTERNAL_ERROR";

    /* Customer Controller */
    public static final String SAVE_CUSTOMER_MESSAGE = "Customer Saved Successfully";

    public static final String CUSTOMER_ALREADY_EXIST_BY_EMAIL_MESSAGE = "Customer Already Exist By Same Email";

    public static final String CUSTOMER_ALREADY_EXIST_BY_PHONE_NUMBER_MESSAGE = "Customer Already Exist By Phone Same Number";

    public static final String UNAUTHORIZED_USER = "Unauthorized User";

    public static final String CUSTOMER_NOT_FOUND = "Customer Not Found";

    public static final String CUSTOMER_AUTHENTICATION_FAILED = "Customer Email or Password is Invalid";

    public static final String CUSTOMER_LOGGED_IN_SUCCESS = "Customer Logged-in Successfully";

    // Response Codes.

    public static final String SAVE_CUSTOMER_MESSAGE_CODE = "CUSTOMER_SAVED";

    public static final String CUSTOMER_ALREADY_EXIST_MESSAGE_CODE = "CUSTOMER_ALREADY_EXIST";

    public static final String UNAUTHORIZED_USER_CODE = "INVALID_CUSTOMER";

    public static final String CUSTOMER_NOT_FOUND_CODE = "CUSTOMER_NOT_FOUND";

    public static final String CUSTOMER_AUTHENTICATION_FAILED_CODE = "AUTHENTICATION_FAILED";

    public static final String CUSTOMER_LOGGED_IN_SUCCESS_CODE = "CUSTOMER_LOGGED_IN";

}
