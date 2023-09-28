package org.example.entities.employment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.advertisement.Advertisement;

import java.util.List;
import java.util.Objects;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employment {

    @Id
    private UUID id;


    private String form;

    @ManyToMany()
    @JoinTable(name = "company_employment_type", joinColumns = @JoinColumn(name = "employment_id"),
    inverseJoinColumns = @JoinColumn(name = "advertisement_id")
    )
    private List<Advertisement> advertisement;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employment that = (Employment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
