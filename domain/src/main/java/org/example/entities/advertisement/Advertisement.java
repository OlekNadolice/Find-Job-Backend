package org.example.entities.advertisement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.address.Address;
import org.example.entities.applicant.Applicant;
import org.example.entities.benefit.Benefit;
import org.example.entities.company.Company;
import org.example.entities.employment.Employment;
import org.example.entities.requirement.Requirement;
import org.example.entities.seniority.Seniority;
import org.example.valueobjects.Salary;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Advertisement {

    @Id
    private UUID id;

    private String title;

    private String description;

    @Embedded
    private Salary salary;

    @ManyToMany(mappedBy =  "advertisement")
    private List<Employment> formOfEmployment;

    private boolean isActive;

    @ManyToMany(mappedBy = "advertisement")
    private List<Seniority> seniorityLevels;

    @OneToMany(mappedBy = "advertisement")
    private List<Requirement> requirements;

    @ManyToMany(mappedBy = "advertisements")
    private List<Address> placesOfWork;

    @OneToMany(mappedBy = "advertisement")
    private  List<Benefit> benefits;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToMany(mappedBy = "advertisement")
    private Set<Applicant> applicants;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
