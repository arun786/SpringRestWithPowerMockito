package com.arun.rs.SpringRestWithPowerMockito.dao;

import com.arun.rs.SpringRestWithPowerMockito.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Adwiti on 7/12/2018.
 */
@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createAPerson(Person person) {
        Query query = entityManager.createNativeQuery("insert into person(name,age,address)values(?,?,?)");
        query.setParameter(1, person.getName());
        query.setParameter(2, person.getAge());
        query.setParameter(3, person.getAddress());
        return query.executeUpdate();
    }

    @Override
    public int createAPersonUsingJdbcTemplate(Person person) {
        String sqlQuery = "insert into person(name,age,address)values(?,?,?)";
        return jdbcTemplate.update(sqlQuery, new Object[]{person.getName(), person.getAge(), person.getAddress()});
    }
}
