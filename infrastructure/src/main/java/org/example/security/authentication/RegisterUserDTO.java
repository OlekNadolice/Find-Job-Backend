package org.example.security.authentication;




import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.valueobjects.EmailAddress;
import org.example.valueobjects.Password;


@Getter
@NoArgsConstructor(force = true)
public class RegisterUserDTO {

    @NotBlank(message = "First name is required")
    private final String firstName;

    @NotBlank(message = "Last name is required")
    private final String lastName;


    @Valid()
    private final EmailAddress emailAddress;


    @Valid()
    private final Password password;







    public RegisterUserDTO(String firstName, String lastName, EmailAddress emailAddress, Password password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;

    }
}
