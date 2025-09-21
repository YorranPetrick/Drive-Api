package com.yp.DriveApi.security.filter;

import com.yp.DriveApi.security.token.TokenJwt;
import com.yp.DriveApi.service.client.ClientServiceDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterSecurity extends OncePerRequestFilter {

    @Autowired
    private TokenJwt tokenJwt;

    // Using the clientServiceDetails to search for the Client,
    // as it contains the method that returns the instance of ClientDetails with its parameters
    @Autowired
    private ClientServiceDetails clientServiceDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tokenRetrieved = retrieveToken(request);

        if (tokenRetrieved != null){
            var subject = tokenJwt.getSubject(tokenRetrieved);
            var client = clientServiceDetails.loadUserByUsername(subject.toString());

            var authentication = new UsernamePasswordAuthenticationToken(client, null, client.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String retrieveToken(HttpServletRequest request){
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null){
            return authorizationHeader.replace("Bearer ", "");
        } else {
            return null;
        }
    }
}
