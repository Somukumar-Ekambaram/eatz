package com.cdw.eatz.common.util;

import com.cdw.eatz.common.exception.AccessDeniedException;
import com.cdw.eatz.common.exception.CustomerAuthenticationFailedException;
import com.cdw.eatz.common.exception.CustomerExistException;
import com.cdw.eatz.common.exception.CustomerNotFoundException;
import com.cdw.eatz.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * GlobalExceptionHandlerUtil.java
 * A Java Class that Handles global Exceptions
 *
 * @author somukumar.ekambaram
 * @since May 2023
 * @version 0.0.1-SNAPSHOT
 */
@ControllerAdvice
public class GlobalExceptionHandlerUtil {

    /**
     * Method to handle common exceptions
     *
     * @param exception {Exception}
     * @return apiResponse {ApiResponse<String>}
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    private ApiResponse<String> handleCommonException(Exception exception) {

        ApiResponse<String> apiResponse = new ApiResponse<>(false, exception.getMessage(), null);

        return apiResponse;
    }

    /**
     * Method to handle access denied exception.
     *
     * @param accessDeniedException {AccessDeniedException}
     * @return apiResponse {ApiResponse<String>}
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    private ApiResponse<String> handleAccessDeniedException(AccessDeniedException accessDeniedException) {

        ApiResponse<String> apiResponse = new ApiResponse<>(false, accessDeniedException.getMessage(), null);

        return apiResponse;
    }

    /**
     * Method to handle customer exist exception.
     *
     * @param customerExistException {CustomerExistException}
     * @return apiResponse {ApiResponse<String>}
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CONFLICT)
    private ApiResponse<String> handleCustomerExistException(CustomerExistException customerExistException) {

        ApiResponse<String> apiResponse = new ApiResponse<>(false, customerExistException.getMessage(), null);

        return apiResponse;
    }

    /**
     * Method to handle customer not found exception.
     *
     * @param customerNotFoundException {CustomerNotFoundException}
     * @return apiResponse {ApiResponse<String>}
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    private ApiResponse<String> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException) {

        ApiResponse<String> apiResponse = new ApiResponse<>(false, customerNotFoundException.getMessage(), null);

        return apiResponse;
    }

    /**
     * Method to handle customer authentication failed exception.
     *
     * @param customerAuthenticationFailedException {CustomerAuthenticationFailedException}
     * @return apiResponse {ApiResponse<String>}
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private ApiResponse<String> handleCustomerAuthenticationFailedException(CustomerAuthenticationFailedException customerAuthenticationFailedException) {

        ApiResponse<String> apiResponse = new ApiResponse<>(false, customerAuthenticationFailedException.getMessage(), null);

        return apiResponse;
    }
}
