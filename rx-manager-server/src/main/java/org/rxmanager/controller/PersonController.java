package org.rxmanager.controller;

import org.rxmanager.mapper.CreatePersonRequestMapper;
import org.rxmanager.mapper.CreatePersonResponseMapper;
import org.rxmanager.model.Person;
import org.rxmanager.service.PersonService;
import org.rxmanager.view.request.CreatePersonRequest;
import org.rxmanager.view.response.CreatePersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePersonResponse save(@RequestBody @Valid CreatePersonRequest request) {
        Person person = personService.save(CreatePersonRequestMapper.getPerson(request));
        CreatePersonResponse response = CreatePersonResponseMapper.getResponse(person);

        return response;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person getPerson(@RequestParam @NotNull Long contactNumber, @RequestParam @NotNull(message = "Country code cannot be null") Integer countryCode) {
        return personService.findPerson(contactNumber, countryCode);
    }

}
