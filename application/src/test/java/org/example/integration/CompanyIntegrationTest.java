package org.example.integration;


import org.example.command.company.create.CreateCompanyCommand;
import org.example.entities.address.Address;
import org.example.entities.category.Category;
import org.example.entities.employer.Employer;
import org.example.valueobjects.NipNumber;
import org.example.valueobjects.RegonNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;


public class CompanyIntegrationTest extends  BaseIntegrationTest{




//    @Test
//  public  void shouldCreateCompany() {
//        Employer employer = createEmployer("test123@wp.pl",
//                "Password123456!",
//                "Tester",
//                "tester");
//
//         CreateCompanyCommand command = new CreateCompanyCommand(
//                "TestCompany",
//                null,
//                Set.of(new Category()),
//                "description",
//                List.of(new Address()),
//                new NipNumber("nipTest"),
//                new RegonNumber("regonTest"),
//                LocalDate.now()
//        );
//
//         mediator.processRequest(command);
//
//         Assertions.assertTrue(companyQueryRepository.findByCompanyNipNumber(command.getCompanyNipNumber()).isPresent());
//
//
//    }
}
