package com.cdw.eatz.common.util.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JwtInterceptorUtil.java
 * Java Class that handle Http Servlet requests  and responses
 *
 * @author somukumar.ekambaram
 * @since May 2023
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class JwtInterceptorUtil implements HandlerInterceptor {

    @Autowired
    private JsonWebTokenUtil jsonWebTokenUtil;

    /**
     * Method to Handle Http Request and Response.
     *
     * @param request  {HttpServletRequest}
     * @param response {HttpServletResponse}
     * @param handler  {Object}
     * @return {boolean}
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authToken = request.getHeader("Authorization");
        String method = request.getMethod().toLowerCase();
        String uri = request.getRequestURI();

        if(!((uri.equalsIgnoreCase("/EatzAPI/customer") && (method.equalsIgnoreCase("post"))) || (uri.equalsIgnoreCase("/EatzAPI/customer/login")))) {
            jsonWebTokenUtil.verifyJsonWebToken(authToken);
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
