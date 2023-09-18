package org.example.entities.company;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.advertisement.Advertisement;
import org.example.entities.employer.Employer;
import org.example.enums.CompanyCategoryType;
import org.example.valueobjects.NipNumber;
import org.example.valueobjects.RegonNumber;


import java.time.LocalDate;
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

    @ElementCollection(targetClass = CompanyCategoryType.class)
    @Enumerated(EnumType.STRING)
    private Set<CompanyCategoryType> companyCategory;

    private String  companyDescription;

    private String companyAddress;

    @Embedded()
    @Column(unique = true)
    private NipNumber companyNipNumber;

    @Embedded()
    @Column(unique = true)
    private RegonNumber companyRegonNumber;

    private LocalDate companyCreationDate;

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
