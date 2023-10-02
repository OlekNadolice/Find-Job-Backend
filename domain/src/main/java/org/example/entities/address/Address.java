package org.example.entities.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.advertisement.Advertisement;
import org.example.entities.company.Company;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address {


    @Id
    private UUID id;


    private String city;


    private String street;

    @ManyToMany()
    @JoinTable(name =  "company_location",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name =  "company_id")

    )
    private List<Company> company;


    @ManyToMany()
    @JoinTable(name =  "advertisement_location",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name =  "advertisement_id")

    )
    private List<Advertisement> advertisements;






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
