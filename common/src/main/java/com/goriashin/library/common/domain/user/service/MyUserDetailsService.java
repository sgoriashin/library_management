package com.goriashin.library.common.domain.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MyUserDetailsService extends UserDetailsService {

    UserDetails loadUserByUsername (String username) throws UsernameNotFoundException;
}
