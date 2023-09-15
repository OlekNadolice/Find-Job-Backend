package org.example.controllers.command.user;

import jakarta.validation.Valid;
import org.example.command.user.create.CreateUserCommand;
import org.example.command.user.delete.DeleteUserCommand;
import org.example.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserCommandController {

     private  final Mediator mediator;




    public UserCommandController(Mediator mediator) {
        this.mediator = mediator;

    }



    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody CreateUserCommand command) {
         this.mediator.processRequest(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    };

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID userId) {
        var command = new DeleteUserCommand(userId);
        this.mediator.processRequest(command);
        return  ResponseEntity.noContent().build();
    };

}
