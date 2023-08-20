package org.example.services.validation;

import org.example.exceptions.CompanyNotFoundException;
import org.example.exceptions.NipNumberAlreadyTakenException;
import org.example.exceptions.RegonNumberAlreadyTakenException;

import org.example.model.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


@Component
public class CompanyValidator {

    private final CompanyRepository companyRepository;


    @Autowired
    public CompanyValidator(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public void checkIfCompanyExists(Long companyId) {
        this.companyRepository.findById(companyId).orElseThrow(() ->
                new CompanyNotFoundException("Company with a given id doesnt exists"));
    }

    public void checkIfCompanyRegonNumberTaken(Long companyRegonNumber) {
        var c = this.companyRepository.findByCompanyRegonNumber(companyRegonNumber);
        if (c.isPresent()) {
            throw new RegonNumberAlreadyTakenException("Company with a given regon number already exists");
        }
    }

    public void checkIfCompanyNipNumberTaken(Long companyNipNumber) {
        var c = this.companyRepository.findByCompanyNipNumber(companyNipNumber);
        if (c.isPresent()) {
            throw new NipNumberAlreadyTakenException("Company with a given nip number already exists");
        }

    }
}
