package com.kamilisler.cruddemo.dao;

import com.kamilisler.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int Id);
    void save(Employee employee);
    void deleteById(int Id);
}
