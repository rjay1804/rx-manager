package org.rxmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false, updatable = false)
    @Min(value = 6000000000L, message = "Contact Number must be >= 6000000000")
    @Max(value = 9999999999L, message = "Contact Number must be <= 9999999999")
    private Long contactNumber;

    @Column(nullable = false, updatable = false)
    @Min(1)
    @Max(999)
    private Integer countryCode;

    @Column(nullable = false)
    @Email(message = "Invalid email")
    private String emailId;

    @Column(nullable = false)
    @Past
    private LocalDate dateOfBirth;

    @Column(nullable = false, columnDefinition = "enum('PATIENT', 'DOCTOR')")
    @Enumerated(EnumType.STRING)
    private CATEGORY category;

    public enum CATEGORY {
        PATIENT,
        DOCTOR
    }
}
