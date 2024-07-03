package com.example.twitterclone.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class JwtTokenValidator implements Filter {

//    @Override
//    public void doFiler(ServletRequest request, ServletResponse response, FilterChain chain) {
//
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        if(jwt != null){
            jwt=jwt.substring(7);
        }
        
    }
}
