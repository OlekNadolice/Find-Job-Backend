package org.example.query.user;

import org.example.repositories.User.UserQueryRepository;
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
    }
}
