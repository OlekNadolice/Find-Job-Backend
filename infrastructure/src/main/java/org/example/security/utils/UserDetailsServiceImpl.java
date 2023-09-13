package org.example.security.utils;

import org.example.repositories.User.UserQueryRepository;
import org.example.security.utils.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  final UserQueryRepository userQueryRepository;


    public UserDetailsServiceImpl(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     return   userQueryRepository.findByEmailAddress(username).map(UserDetailsImpl::new)
                .orElseThrow(() ->  new UsernameNotFoundException("User with a given email doesnt exists"));

    }
}
