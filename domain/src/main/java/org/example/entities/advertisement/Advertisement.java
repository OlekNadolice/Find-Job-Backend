package org.example.entities.advertisement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.applicant.Applicant;
import org.example.entities.company.Company;

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

    private String currency;

    private String money;

    private String formOfEmployment;

    private boolean isActive;


    private String seniorityLevel;

    private List<String> requirements;

    private List<String> placesOfWork;

    private  List<String> benefits;


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
