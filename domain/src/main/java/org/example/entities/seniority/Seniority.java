package org.example.entities.seniority;

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
public class Seniority {


    @Id
    private UUID id;

    private String title;

    @ManyToMany()
    @JoinTable(name = "advertisement_seniority_level",
            joinColumns = @JoinColumn(name = "seniority_id"),
    inverseJoinColumns = @JoinColumn(name = "advertisement_id"))
    private List<Advertisement> advertisement;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seniority seniority = (Seniority) o;
        return Objects.equals(id, seniority.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
