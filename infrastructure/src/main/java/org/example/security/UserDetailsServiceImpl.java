package org.example.security;

import org.example.repositories.User.UserQueryRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
