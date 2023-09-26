package org.example.controllers.command.employer;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.command.employer.create.CreateEmployerCommand;
import org.example.mediator.Mediator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employer")
public class EmployerCommandController {


    private final Mediator mediator;

    public EmployerCommandController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping()
    @Operation(summary =  "Create new employer")
    @ApiResponses({
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400")
    })
    public ResponseEntity<Void> createEmployer(@Valid @RequestBody CreateEmployerCommand command) {
        this.mediator.processRequest(command);
        return ResponseEntity.status(201).build();
    }
}
