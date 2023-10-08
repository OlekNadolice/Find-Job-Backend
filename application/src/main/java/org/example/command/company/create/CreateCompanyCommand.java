package org.example.command.company.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.example.IRequest;
import org.example.entities.address.Address;
import org.example.entities.category.Category;
import org.example.valueobjects.NipNumber;
import org.example.valueobjects.RegonNumber;

import java.time.LocalDate;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
public class CreateCompanyCommand implements IRequest {

    @NotBlank(message = "Company name is required")
    @Size(max = 255, message = "Maximum length for company name exceeded")
    private final String companyName;
    private final String companyImage;

    @NotNull(message = "Company category is required")
    private final Set<Category> companyCategories;
    @NotBlank(message = "Company description is required")
    @Size(max = 500, message = "Maximum length for company description exceeded")
    private final String companyDescription;
    @NotBlank(message = "Address is required")
    private final List<Address> companyAddress;
    @NotNull(message = "Nip number is required")
    private final NipNumber companyNipNumber;
    @NotNull(message = "Regon number is required")
    private final RegonNumber companyRegonNumber;
    @NotNull(message = "Creation date is required")
    private final LocalDate companyCreationDate;




    public CreateCompanyCommand(String companyName, String companyImage, Set<Category> companyCategories, String companyDescription, List<Address> companyAddress, NipNumber companyNipNumber, RegonNumber companyRegonNumber, LocalDate companyCreationDate) {
        this.companyName = companyName;
        this.companyImage = companyImage;
        this.companyCategories = companyCategories;
        this.companyDescription = companyDescription;
        this.companyAddress = companyAddress;
        this.companyNipNumber = companyNipNumber;
        this.companyRegonNumber = companyRegonNumber;
        this.companyCreationDate = companyCreationDate;

    }
}
