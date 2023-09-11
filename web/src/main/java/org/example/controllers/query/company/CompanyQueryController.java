package org.example.controllers.query.company;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.dto.company.CompanyDTO;
import org.example.query.company.CompanyDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyQueryController {

    private final CompanyDao companyDao;


    public CompanyQueryController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Operation(summary = "Get all companies assigned to the user")
    @ApiResponse(responseCode = "200")
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
       var company = this.companyDao.getAllCompanies();
        return ResponseEntity.ok(company);
    }


    @Operation(summary = "Get company by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404"),
    })
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long companyId) {
        var company = this.companyDao.getCompanyById(companyId);
        return ResponseEntity.ok(company);
    }

}
