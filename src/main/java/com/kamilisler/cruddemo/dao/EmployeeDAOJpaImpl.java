package com.kamilisler.cruddemo.dao;

import com.kamilisler.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private final EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        Query theQuery = entityManager.createQuery("from Employee");
        //exec query get result list
        // return results
        List<Employee> employees = theQuery.getResultList();
 //asda
        return employees;
    }

    @Override
    public Employee findById(int Id) {
        Employee theEmployee = entityManager.find(Employee.class,Id);
        return theEmployee;
    }

    @Override
    public void save( Employee theEmployee) {
        // save or update the employee. if the id= 0 instert, otherwise update
        Employee dbEmployee = entityManager.merge(theEmployee);

        // update with id from db.. so we can get generated id for save/insert
        theEmployee.setId(dbEmployee.getId()); // useful for rest api


    }

    @Override
    public void deleteById(int Id) {
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",Id);
        theQuery.executeUpdate();
    }
}
