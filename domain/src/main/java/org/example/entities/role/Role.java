package org.example.entities.role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.entities.user.CustomUser;
import org.example.enums.RoleType;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Enumerated(value = EnumType.STRING)
    private RoleType name;


    @ManyToMany(mappedBy = "roles")
    private Set<CustomUser> users;


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
