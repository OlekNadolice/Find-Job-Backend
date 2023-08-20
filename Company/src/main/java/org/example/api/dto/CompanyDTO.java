package org.example.api.dto;

import org.example.model.CompanyCategory;

import java.util.Date;
import java.util.Set;

public record CompanyDTO(String companyName,
                         String companyImage,
                         String companyDescription,
                         Set<CompanyCategory> companyCategories,
                         Long companyId,
                         String companyAddress,
                         Date companyCreationDate,

                         Long companyNipNumber,

                         Long companyRegonNumber
                         ) {
}
