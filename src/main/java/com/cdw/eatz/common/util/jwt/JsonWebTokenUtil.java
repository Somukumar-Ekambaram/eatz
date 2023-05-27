package com.cdw.eatz.common.util.jwt;

import com.cdw.eatz.common.exception.AccessDeniedException;
import com.cdw.eatz.customer.entity.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

import static com.cdw.eatz.common.constant.CommonUtilsConstant.EXPIRY_TIME;
import static com.cdw.eatz.common.constant.CommonUtilsConstant.SECRET_KEY;
import static com.cdw.eatz.common.constant.ResponseMessageConstant.UNAUTHORIZED_USER;

/**
 * JsonWebTokenUtil.java
 * A Java Util class to generate Json Web Token.
 *
 * @author somukumar.ekambaram
 * @version 0.0.1-SNAPSHOT
 * @since May 2023
 */
@Component
public class JsonWebTokenUtil {

    private static final String secretKey = SECRET_KEY;

    private static final long expiryDuration = EXPIRY_TIME;

    /**
     * Method to convert secret key to Key.
     *
     * @return keys {Key}
     */
    private Key getSecretKey() {
        Keys keys = null;
        byte[] bytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return keys.hmacShaKeyFor(bytes);
    }

    /**
     * Method to generate json web token
     *
     * @param customer {Customer}
     * @return token {String}
     */
    public String generateJsonWebToken(Customer customer) {

        long expiryTime = System.currentTimeMillis() + expiryDuration * 1000;
        Date issueAt = new Date();
        Date expiryAt = new Date(expiryTime);
        String issuer = customer.getUsername();
        UUID issuerId = customer.getCustomerId();
        String issuerEmail = customer.getEmail();

        // create claims
        Claims claims = Jwts.claims();

        // set values for claims
        claims.setIssuer(issuer);
        claims.setId(issuerId.toString());
        claims.setSubject(issuerEmail);
        claims.setExpiration(expiryAt);
        claims.setIssuedAt(issueAt);

        // generate Json Web Token using JWT claims
        Key key = null;
        String token = Jwts.builder().setClaims(claims).signWith(getSecretKey(), SignatureAlgorithm.HS512).compact();

        return token;
    }

    /**
     * Method to verify json web token
     *
     * @param token {String}
     * @throws AccessDeniedException
     */
    public void verifyJsonWebToken(String token) throws AccessDeniedException {

        try {
            Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parse(token);
        } catch (AccessDeniedException accessDeniedException) {
            throw new AccessDeniedException(UNAUTHORIZED_USER);
        }
    }
}
