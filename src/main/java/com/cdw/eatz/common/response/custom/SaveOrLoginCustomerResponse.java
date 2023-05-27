package com.cdw.eatz.common.response.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * A Java class for response structure for Save customer operations.
 *
 * @author somukumar.ekambaram
 * @since May 2023
 * @version 0.0.1-SNAPSHOT
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaveOrLoginCustomerResponse {

    public UUID customerId;

    public String username;

    public String email;

    public String bearerToken;

}
