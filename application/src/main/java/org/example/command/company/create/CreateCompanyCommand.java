package org.example.command.company.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.example.Entities.Company.CompanyCategory;
import org.example.IRequest;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
public class CreateCompanyCommand implements IRequest {

    @NotBlank(message = "Company name is required")
    @Size(max = 255, message = "Maximum length for company name exceeded")
    private final String companyName;
    private final String companyImage;

    @NotNull(message = "Company category is required")
    private final Set<CompanyCategory> companyCategories;
    @NotBlank(message = "Company description is required")
    @Size(max = 500, message = "Maximum length for company description exceeded")
    private final String companyDescription;
    @NotBlank(message = "Address is required")
    private final String companyAddress;
    @NotNull(message = "Nip number is required")
    private final Long companyNipNumber;
    @NotNull(message = "Regon number is required")
    private final Long companyRegonNumber;
    @NotNull(message = "Creation date is required")
    private final Date companyCreationDate;

    private final UUID id;


    public CreateCompanyCommand(String companyName, String companyImage, Set<CompanyCategory> companyCategories, String companyDescription, String companyAddress, Long companyNipNumber, Long companyRegonNumber, Date companyCreationDate) {
        this.companyName = companyName;
        this.companyImage = companyImage;
        this.companyCategories = companyCategories;
        this.companyDescription = companyDescription;
        this.companyAddress = companyAddress;
        this.companyNipNumber = companyNipNumber;
        this.companyRegonNumber = companyRegonNumber;
        this.companyCreationDate = companyCreationDate;
        this.id = UUID.randomUUID();
    }
}
