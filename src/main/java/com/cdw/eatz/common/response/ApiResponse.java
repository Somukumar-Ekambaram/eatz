package com.cdw.eatz.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A Java class for common API response structure.
 *
 * @author somukumar.ekambaram
 * @version 0.0.1-SNAPSHOT
 * @since May 2023
 * @param <T>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {

    public boolean success;

    public String code;

    public String message;

    public T data;
}
