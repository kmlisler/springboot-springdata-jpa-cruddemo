package com.kamilisler.cruddemo.service;

import com.kamilisler.cruddemo.dao.EmployeeDAO;
import com.kamilisler.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    @Autowired

    public EmployeeServiceImpl (@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int Id) {
        return employeeDAO.findById(Id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int Id) {
        employeeDAO.deleteById(Id);
    }
}
