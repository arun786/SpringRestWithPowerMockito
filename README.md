# SpringRestWithPowerMockito
 
 
 The below dependencies are added to enable power mockito
 
    <dependency>
        <groupId>org.powermock</groupId>
        <artifactId>powermock-module-junit4</artifactId>
        <version>LATEST</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.powermock</groupId>
        <artifactId>powermock-api-mockito</artifactId>
        <version>LATEST</version>
        <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mockito/mockito-all -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-all</artifactId>
        <version>1.9.5</version>
        <scope>test</scope>
    </dependency>

# Create a Person Using a Native Query

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

## Create using Jdbc template

    @Override
        public int createAPersonUsingJdbcTemplate(Person person) {
            String sqlQuery = "insert into person(name,age,address)values(?,?,?)";
            return jdbcTemplate.update(sqlQuery, new Object[]{person.getName(), person.getAge(), person.getAddress()});
        }