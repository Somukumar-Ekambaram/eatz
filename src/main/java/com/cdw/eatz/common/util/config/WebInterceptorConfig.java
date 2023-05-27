package com.cdw.eatz.common.util.config;

import com.cdw.eatz.common.util.jwt.JwtInterceptorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * A Spring Configuration Class.
 *
 * @author somukumar.ekambaram
 * @version 0.0.1-SNAPSHOT
 * @since May 2023
 */
@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptorUtil jwtInterceptorUtil;

    /**
     * Method to add interceptors.
     *
     * @param interceptorRegistry {InterceptorRegistry}
     */
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        interceptorRegistry.addInterceptor(jwtInterceptorUtil);
    }

}
