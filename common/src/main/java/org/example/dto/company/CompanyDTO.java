package org.example.dto.company;


import org.example.enums.CompanyCategoryType;

import java.util.Date;
import java.util.Set;

public record CompanyDTO(String companyName,
                         String companyImage,
                         String companyDescription,
                         Set<CompanyCategoryType> companyCategories,
                         java.util.UUID companyId,
                         String companyAddress,
                         Date companyCreationDate,

                         Long companyNipNumber,

                         Long companyRegonNumber
) {
}