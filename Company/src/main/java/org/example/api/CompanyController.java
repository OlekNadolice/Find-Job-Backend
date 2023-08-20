package org.example.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.api.dto.CompanyDTO;
import org.example.api.dto.CreateCompanyDTO;
import org.example.services.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyServiceImpl companyServiceImpl;

     @Autowired
    public CompanyController(CompanyServiceImpl companyServiceImpl) {
        this.companyServiceImpl = companyServiceImpl;
    }

    @Operation(summary = "Get all companies assigned to the user")
    @ApiResponse(responseCode = "200")
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        var companies =  this.companyServiceImpl.getAllCompanies();

        return ResponseEntity.ok(companies);
    }


    @Operation(summary = "Get company by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404"),
    })
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long companyId) {
        var company = this.companyServiceImpl.getCompanyById(companyId);
        return ResponseEntity.ok(company);
    }



    @Operation(summary = "Create new company")
    @ApiResponses({
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400"),
    })
    @PostMapping
    public ResponseEntity<CreateCompanyDTO> createCompany(@Valid @RequestBody CreateCompanyDTO company) {
        var c = this.companyServiceImpl.createCompany(company);
         return new ResponseEntity<>(c, HttpStatus.CREATED);
    }


    @Operation(summary =  "Delete company by id")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    @DeleteMapping("/{companyId}")
    public ResponseEntity deleteCompany(@PathVariable Long companyId) {
         this.companyServiceImpl.deleteCompanyById(companyId);
         return  ResponseEntity.noContent().build();
    }


}
