package org.example.valueobjects;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@Getter
@NoArgsConstructor
@Accessors(fluent = true)
@Embeddable
@EqualsAndHashCode(of = "value")
public class EmailAddress {

    @NotBlank(message = "Email address is required")
    @Email(message =  "Invalid email address")
    private String value;

    public EmailAddress(String emailAddress) {
        this.value= emailAddress;
    }

    @JsonValue()
    public String toJson() {
        return  value;
    }


    @Override
    public String toString() {
        return value;
    }


}
