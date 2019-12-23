package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ApiAuthorizationInterceptor interceptor = new ApiAuthorizationInterceptor(authenticationManager);

        registry.addInterceptor(interceptor);
    }
}
