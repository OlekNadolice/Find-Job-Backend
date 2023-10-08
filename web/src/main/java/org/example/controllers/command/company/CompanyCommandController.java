package org.example.controllers.command.company;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.command.company.create.CreateCompanyCommand;
import org.example.command.company.delete.DeleteCompanyCommand;
import org.example.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/companies")
public class CompanyCommandController {
   private final Mediator mediator;



    public CompanyCommandController(Mediator mediator) {
        this.mediator = mediator;

    }



    @Operation(summary = "Create new company")
    @ApiResponses({
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400"),
    })
    @PostMapping
    public ResponseEntity<Void> createCompany(@Valid @RequestBody CreateCompanyCommand command) {
        mediator.processRequest(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Operation(summary =  "Delete company by id")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable DeleteCompanyCommand command) {
        mediator.processRequest(command);
        return  ResponseEntity.noContent().build();
    }};
