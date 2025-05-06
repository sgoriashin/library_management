package com.goriashin.library.core.domain.user.service;

import com.goriashin.library.common.domain.user.service.MyUserDetailsService;
import com.goriashin.library.core.domain.user.model.UserTM;
import com.goriashin.library.core.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
@Slf4j
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTM userTM = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        log.info("User " + username + " logged in");
        return new org.springframework.security.core.userdetails.User(
                userTM.getUsername(),
                userTM.getPassword(),
                Collections.emptyList()
        );
    }

}
