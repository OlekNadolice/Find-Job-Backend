package org.example.valueobjects;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode(of = "value")
public class Password {

    private static final String pattern = "\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$\"";

    @NotBlank(message = "Password is required")
    @Pattern(message = "Password must contains at least 8 characters and one special sign", regexp = pattern)
    private  String value;


    public Password(String password) {
        this.value = password;
    }


    @JsonValue()
    public String toJson() {
        return this.value;
    }



}
