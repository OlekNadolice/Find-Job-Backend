package org.example.entities.applicant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.advertisement.Advertisement;
import org.example.entities.employee.Employee;
import org.example.enums.ApplicationStatusType;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Applicant {


    @Id
    private UUID id;


    @ManyToOne()
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;


    @ManyToOne()
    @JoinColumn(name =  "employee_id")
    private Employee employee;


    @Enumerated(EnumType.STRING)
    private ApplicationStatusType status;


    private LocalDate applicationDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return Objects.equals(id, applicant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
