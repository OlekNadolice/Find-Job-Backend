package org.example.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.model.CompanyCategory;

import java.util.Date;
import java.util.Set;


public record CreateCompanyDTO(
        @NotBlank(message = "Company name is required")
        @Size(max = 255, message = "Maximum length for company name exceeded")
        String companyName,
        String companyImage,

        @NotNull( message = "Company category is required")
        Set<CompanyCategory> companyCategories,
        @NotBlank(message =  "Company description is required")
        @Size(max = 500, message = "Maximum length for company description exceeded")
        String companyDescription,
        @NotBlank(message = "Address is required")
        String companyAddress,
        @NotNull(message =  "Nip number is required")
        Long companyNipNumber,
        @NotNull(message =  "Regon number is required")
        Long companyRegonNumber,
        @NotNull(message =  "Creation date is required")
        Date companyCreationDate
        ) {
}
