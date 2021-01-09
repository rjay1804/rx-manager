package org.rxmanager.view.request;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class CreatePersonRequest {

    @NotBlank(message = "firstName cannot be blank")
    private String firstName;

    @NotBlank(message = "lastName cannot be blank")
    private String lastName;

    @Min(6000000000L) @Max(9999999999L)
    private Long contactNumber;

    @Min(1) @Max(999)
    private Integer countryCode;

    @Email(message = "emailId should be valid")
    private String emailId;

    @Past
    private LocalDate dateOfBirth;

    @NotBlank
    private String category;
}
