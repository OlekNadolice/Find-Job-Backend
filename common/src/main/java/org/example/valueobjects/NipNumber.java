package org.example.valueobjects;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "value")
@Embeddable
@NoArgsConstructor(force = true)
public class NipNumber {

    private  final  static String nipPattern = "";

    @NotNull(message = "Nip number is required")
    @Pattern(message = "Invalid nip number", regexp = nipPattern)
    private  final String value;


    public NipNumber(String nipNumber) {
        this.value = nipNumber;
    }



}
