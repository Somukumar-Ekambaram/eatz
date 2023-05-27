package com.cdw.eatz.common.exception;

/**
 * CustomerAuthenticationFailedException.java
 * A Java Custom Exception Class
 *
 * @author somukumar.ekambaram
 * @since May 2023
 * @version 0.0.1-SNAPSHOT
 */
public class CustomerAuthenticationFailedException extends RuntimeException {

    public CustomerAuthenticationFailedException(String message) {
        super(message);
    }
}
