package org.rxmanager.view.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class CreatePersonResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private Long contactNumber;
    private Integer countryCode;
    private String emailId;
    private LocalDate dateOfBirth;
    private String category;

}
