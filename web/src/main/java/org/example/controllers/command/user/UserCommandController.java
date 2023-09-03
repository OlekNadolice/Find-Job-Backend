package org.example.controllers.command.user;

import jakarta.validation.Valid;
import org.example.command.user.create.CreateUserCommand;
import org.example.command.user.delete.DeleteUserCommand;
import org.example.dto.user.CreateUserDTO;
import org.example.mediator.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserCommandController {

     private  final Mediator mediator;

     @Autowired
    public UserCommandController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateUserDTO> createUser(@Valid @RequestBody CreateUserCommand command) {
         this.mediator.processRequest(command);
        return null;
    };

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object>  deleteUserById(@PathVariable Long userId) {
        var command = new DeleteUserCommand(userId);
        this.mediator.processRequest(command);
        return null;
    };

}
