package org.example.model;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;

    @ElementCollection(targetClass = CompanyCategory.class)
    @Enumerated(EnumType.STRING)
    private Set<CompanyCategory> companyCategory;

    private String  companyDescription;

    private String companyAddress;

    @Column(unique = true)
    private Long companyNipNumber;

    @Column(unique = true)
    private Long companyRegonNumber;

    private Date companyCreationDate;

    private String companyImage;
}
