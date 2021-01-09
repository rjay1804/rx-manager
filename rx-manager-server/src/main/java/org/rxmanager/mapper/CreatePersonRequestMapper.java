package org.rxmanager.mapper;

import org.rxmanager.model.Person;
import org.rxmanager.view.request.CreatePersonRequest;

public class CreatePersonRequestMapper {

    static public Person getPerson(CreatePersonRequest request) {
        return Person.builder()
                .category(Person.CATEGORY.valueOf(request.getCategory()))
                .contactNumber(request.getContactNumber())
                .countryCode(request.getCountryCode())
                .dateOfBirth(request.getDateOfBirth())
                .emailId(request.getEmailId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }
}
