package org.example.entities.requirement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.advertisement.Advertisement;

import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private  String description;


    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requirement that = (Requirement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
