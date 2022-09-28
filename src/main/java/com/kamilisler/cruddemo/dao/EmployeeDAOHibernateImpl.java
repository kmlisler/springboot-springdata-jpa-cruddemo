package com.kamilisler.cruddemo.dao;

import com.kamilisler.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    // define field for entity manager
    private final EntityManager entityManager;
    //  set up const injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // get the current hibernate session
        Query<Employee> theQuery;
        try (Session currentSession = entityManager.unwrap(Session.class)) {
            // create a query
            theQuery = currentSession.createQuery("from Employee", Employee.class);
        }
        //return the results
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int Id) {
        // get the current hibernate session
        try (Session currentSession = entityManager.unwrap(Session.class)) {
            // return the employee
            return currentSession.get(Employee.class,Id);
        }
    }

    @Override
    public void save(Employee employee) {
        try (Session currentSession = entityManager.unwrap(Session.class)) {
            // return the employee
            currentSession.saveOrUpdate(employee);
        }
    }

    @Override
    public void deleteById(int Id) {
        try (Session currentSession = entityManager.unwrap(Session.class)) {
            // return the employee
            Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
            theQuery.setParameter("employeeId",Id);
            theQuery.executeUpdate();
        }
    }
}
