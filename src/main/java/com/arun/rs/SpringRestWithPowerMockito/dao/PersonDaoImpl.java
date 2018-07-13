package com.arun.rs.SpringRestWithPowerMockito.dao;

import com.arun.rs.SpringRestWithPowerMockito.model.Person;
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

    @Override
    public int createAPerson(Person person) {
        Query query = entityManager.createNativeQuery("insert into person(name,age,address)values(?,?,?)");
        query.setParameter(1, person.getName());
        query.setParameter(2, person.getAge());
        query.setParameter(3, person.getAddress());
        return query.executeUpdate();
    }
}
