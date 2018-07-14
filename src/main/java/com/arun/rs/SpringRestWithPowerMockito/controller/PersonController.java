package com.arun.rs.SpringRestWithPowerMockito.controller;

import com.arun.rs.SpringRestWithPowerMockito.model.Person;
import com.arun.rs.SpringRestWithPowerMockito.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adwiti on 7/12/2018.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/persons/v1/person")
    public ResponseEntity<HttpStatus> createAPerson(@RequestBody Person person) {
        int returnValue = personService.createAPerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/persons/v1/person/jdbcTemplate")
    public ResponseEntity<HttpStatus> createAPersonUsingJdbcTemplate(@RequestBody Person person) {
        int returnValue = personService.createAPersonUsingJdbcTemplate(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/persons/v1/person/namedparameterjdbcTemplate")
    public ResponseEntity<HttpStatus> createAPersonUsingNamedJdbcTemplate(@RequestBody Person person) {
        int returnValue = personService.createAPersonUsingNamedParameterJdbcTemplate(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
