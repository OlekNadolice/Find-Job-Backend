package org.example.query.user;

import org.example.exceptions.RecordNotFoundException;

import org.example.repositories.user.UserQueryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDao {

    private final UserQueryRepository userQueryRepository;


    public UserDao(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }


    public Object getUserById(UUID userId) {
    var user = this.userQueryRepository.findById(userId);
    return null;
//   return user.map(UserMapper)
//            .orElseThrow(() ->
//                    new RecordNotFoundException("User with a given id doesnt exists"));
//
//    }
}}
