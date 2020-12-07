package com.nicoe.library.config;

import com.nicoe.library.controllers.HomeController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthenticationProviderApp extends DaoAuthenticationProvider {
    @Autowired
    UserDetailsService userDetailsService;

    static Logger logger = LogManager.getLogger(AuthenticationProviderApp.class);


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        logger.debug("AuthenticationProviderApp authenticate");
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String name = auth.getName();
        String password = auth.getCredentials().toString();
        UserDetails user = userDetailsService.loadUserByUsername(name);

        if (user == null) {
            logger.error("Utilisateur invalide");
            throw new BadCredentialsException("Username/Password inconnu" + auth.getPrincipal());
        }

        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
