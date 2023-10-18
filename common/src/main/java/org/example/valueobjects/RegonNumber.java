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
public class RegonNumber {

    private static  final String regonPattern = "";

    @NotNull(message = "Regon number is required")
    @Pattern(message = "Invalid regon number", regexp = regonPattern)
    private  final String value;


    public RegonNumber(String regonNumber) {
        this.value = regonNumber;
    }
}
