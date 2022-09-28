package com.kamilisler.cruddemo.service;

import com.kamilisler.cruddemo.dao.EmployeeRepository;
import com.kamilisler.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired

    public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }
    @Override
    public Employee findById(int Id) {
        Optional<Employee> result = employeeRepository.findById(Id);
        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        }
        else{
            // we didnt find the employee
            throw new RuntimeException("Did not find employee id : "+ Id);
        }
        return theEmployee;
    }
    @Override
    public void save(Employee employee) {

        employeeRepository.save(employee);
    }
    @Override
    public void deleteById(int Id) {
        employeeRepository.deleteById(Id);
    }
}
