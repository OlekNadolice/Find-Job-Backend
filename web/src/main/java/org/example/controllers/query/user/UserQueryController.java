package org.example.controllers.query.user;

import org.example.dto.user.UserDTO;
import org.example.mediator.Mediator;
import org.example.query.user.getUser.GetUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserQueryController {

    private final Mediator mediator;

    @Autowired
    public UserQueryController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        var query = new GetUserQuery();
        this.mediator.processRequest(query);
        return null;
    }

}
