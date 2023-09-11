package org.example.Entities.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;


    @Enumerated(value = EnumType.STRING)
    private RoleEnum name;


    @ManyToMany(mappedBy = "roles")
    Set<CustomUser> users;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
