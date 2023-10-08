package org.example.security.authentication;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Getter
@NoArgsConstructor(force = true)
public class RegisterUserDTO {

    @NotBlank(message = "First name is required")
    private final String firstName;

    @NotBlank(message = "Last name is required")
    private final String lastName;

    @NotBlank(message = "Email address is required")
    private final String emailAddress;

    @NotBlank(message = "Password is required")
    private final String password;

    private final UUID id;




    public RegisterUserDTO(String firstName, String lastName, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.id = UUID.randomUUID();
    }
}
