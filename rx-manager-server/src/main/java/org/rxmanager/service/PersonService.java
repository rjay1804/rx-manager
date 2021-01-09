package org.rxmanager.service;

import org.rxmanager.model.Person;
import org.rxmanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person findPerson(Long contactNumber, Integer countryCode) {
        return personRepository.findByContactNumberAndCountryCode(contactNumber, countryCode);
    }
}
