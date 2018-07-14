package com.arun.rs.SpringRestWithPowerMockito.service;

import com.arun.rs.SpringRestWithPowerMockito.dao.PersonDao;
import com.arun.rs.SpringRestWithPowerMockito.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Adwiti on 7/12/2018.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public int createAPerson(Person person) {
        return personDao.createAPerson(person);
    }

    @Override
    public int createAPersonUsingJdbcTemplate(Person person) {
        return personDao.createAPersonUsingJdbcTemplate(person);
    }
}
