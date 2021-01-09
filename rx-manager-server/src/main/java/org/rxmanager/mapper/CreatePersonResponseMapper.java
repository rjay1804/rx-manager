package org.rxmanager.mapper;

import org.rxmanager.model.Person;
import org.rxmanager.view.request.CreatePersonRequest;
import org.rxmanager.view.response.CreatePersonResponse;

public class CreatePersonResponseMapper {

    static public CreatePersonResponse getResponse(Person person) {
        return CreatePersonResponse.builder()
                .id(person.getId())
                .category(person.getCategory().name())
                .contactNumber(person.getContactNumber())
                .countryCode(person.getCountryCode())
                .dateOfBirth(person.getDateOfBirth())
                .emailId(person.getEmailId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build();
    }
}
