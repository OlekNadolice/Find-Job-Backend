package org.example.Entities.Company;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
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

//    @ManyToOne()
//    @JoinColumn(name = "user_id")
//    private CustomUser owner;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
