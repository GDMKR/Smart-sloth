package com.example.security;

/**
 * Created by Yurii on 04.04.2017.
 */


import com.example.user.User;
import com.example.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SecurityServiceImpl implements SecurityService {

    Logger logger = Logger.getLogger(SecurityServiceImpl.class.getName());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        logger.info("User log in after auto registration");
    }

    @Override
    public boolean loginUser(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        logger.info("User log in");
        return true;
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
        return user;
    }

}
