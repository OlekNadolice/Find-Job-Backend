package org.example.api.mapper;

import org.example.api.dto.CompanyDTO;
import org.example.api.dto.CreateCompanyDTO;
import org.example.model.Company;



public class CompanyMapper {


    public static  CompanyDTO ToCompanyDTO (Company company) {
        return new CompanyDTO(company.getCompanyName(),
                company.getCompanyImage(),
                company.getCompanyDescription(),
                company.getCompanyCategory(),
                company.getId(),
                company.getCompanyAddress(),
                company.getCompanyCreationDate(),
                company.getCompanyNipNumber(),
                company.getCompanyRegonNumber()
                );
    }



    public static Company ToEntity(CreateCompanyDTO b) {
        var c = new Company();
        c.setCompanyName(b.companyName());
        c.setCompanyImage(b.companyImage());
        c.setCompanyDescription(b.companyDescription());
        c.setCompanyCategory(b.companyCategories());
        c.setCompanyCreationDate(b.companyCreationDate());
        c.setCompanyAddress(b.companyAddress());
        c.setCompanyNipNumber(b.companyNipNumber());
        c.setCompanyRegonNumber(b.companyRegonNumber());
        return c;
    }
}
