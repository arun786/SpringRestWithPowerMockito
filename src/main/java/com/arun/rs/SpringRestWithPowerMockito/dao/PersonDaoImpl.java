package com.arun.rs.SpringRestWithPowerMockito.dao;

import com.arun.rs.SpringRestWithPowerMockito.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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

    @Override
    public int createAPersonUsingNamedParameterJdbcTemplate(Person person) {
        String sqlQuery = "insert into person(name,age,address)values(:name,:age,:address)";
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("name", person.getName());
        sqlParameterSource.addValue("age", person.getAge());
        sqlParameterSource.addValue("address", person.getAddress());
        return namedParameterJdbcTemplate.update(sqlQuery, sqlParameterSource);
    }
}
