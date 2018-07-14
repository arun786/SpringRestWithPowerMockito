package com.arun.rs.SpringRestWithPowerMockito.service;

import com.arun.rs.SpringRestWithPowerMockito.model.Person;

/**
 * Created by Adwiti on 7/12/2018.
 */
public interface PersonService {
    int createAPerson(Person person);

    int createAPersonUsingJdbcTemplate(Person person);

    int createAPersonUsingNamedParameterJdbcTemplate(Person person);
}
