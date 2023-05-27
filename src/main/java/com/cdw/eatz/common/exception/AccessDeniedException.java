package com.cdw.eatz.common.exception;

/**
 * AccessDeniedException.java
 * A Java Custom Exception Class
 *
 * @author somukumar.ekambaram
 * @since May 2023
 * @version 0.0.1-SNAPSHOT
 */
public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(String message) {
        super(message);
    }
}
