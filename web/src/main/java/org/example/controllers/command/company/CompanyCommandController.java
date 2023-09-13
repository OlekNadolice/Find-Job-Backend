package org.example.controllers.command.company;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.command.company.create.CreateCompanyCommand;
import org.example.command.company.delete.DeleteCompanyCommand;
import org.example.dto.company.CompanyDTO;
import org.example.mediator.Mediator;
import org.example.query.company.CompanyDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyCommandController {
   private final Mediator mediator;

   private  final CompanyDao companyDao;

    public CompanyCommandController(Mediator mediator, CompanyDao companyDao) {
        this.mediator = mediator;
        this.companyDao = companyDao;
    }



    @Operation(summary = "Create new company")
    @ApiResponses({
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400"),
    })
    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@Valid @RequestBody CreateCompanyCommand command) {
        mediator.processRequest(command);
        var company = this.companyDao.getCompanyById(command.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }


    @Operation(summary =  "Delete company by id")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    @DeleteMapping("/{companyId}")
    public ResponseEntity deleteCompany(@PathVariable DeleteCompanyCommand command) {
        mediator.processRequest(command);
        return  ResponseEntity.noContent().build();
    }};
