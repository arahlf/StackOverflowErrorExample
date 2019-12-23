package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ApiAuthorizationInterceptor extends HandlerInterceptorAdapter {
    private static final String DUMMY_USER = "user";
    private static final String DUMMY_PASS = "pass";

    private final AuthenticationManager authenticationManager;

    public ApiAuthorizationInterceptor(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Just for reference purposes, would actually grab stuff from the request
        Authentication dummyRequest = new PreAuthenticatedAuthenticationToken(DUMMY_USER, DUMMY_PASS);
        Authentication authentication = authenticationManager.authenticate(dummyRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return true;
    }
}

