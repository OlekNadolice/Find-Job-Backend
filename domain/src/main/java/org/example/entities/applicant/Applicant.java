package org.example.entities.applicant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.advertisement.Advertisement;
import org.example.entities.employee.Employee;

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


    private String status;


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
