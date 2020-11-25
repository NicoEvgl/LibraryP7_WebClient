package com.nicoe.library.service;

import com.nicoe.library.beans.User;
import com.nicoe.library.proxies.LibraryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDetailsService")
public class UserDetailsServiceCustom implements UserDetailsService {

    private final LibraryProxy libraryProxy;

    @Autowired
    public UserDetailsServiceCustom(LibraryProxy libraryProxy) {
        this.libraryProxy = libraryProxy;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= libraryProxy.findUserByPseudo(username);
        if (user == null){
            throw new UsernameNotFoundException(username + " non trouvé");
        }
        return user;
    }
}
