package org.example.controllers.command.employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.command.employee.create.CreateEmployeeCommand;
import org.example.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeCommandController {

    private  final Mediator mediator;


    public EmployeeCommandController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping()
    @Operation(summary =  "Create new employee")
    @ApiResponses({
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400")
    })
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody CreateEmployeeCommand command) {
        this.mediator.processRequest(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    };
}
