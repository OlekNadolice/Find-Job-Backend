package org.example.controllers.query.user;

import org.example.dto.user.UserDTO;


import org.example.query.user.UserDao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserQueryController {

  private final UserDao userDao;

    public UserQueryController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId) {
        var user  = this.userDao.getUserById(userId);
        return null;
    }

}
