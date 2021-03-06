package org.rxmanager.repository;

import org.rxmanager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    Person findByContactNumberAndCountryCode(Long contactNumber, Integer countryCode);
}
