package org.example.entities.company;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.advertisement.Advertisement;
import org.example.entities.employer.Employer;


import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Company {

    @Id
    private UUID id;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;


    @OneToMany(mappedBy = "company")
    private  Set<Advertisement> advertisements;


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
