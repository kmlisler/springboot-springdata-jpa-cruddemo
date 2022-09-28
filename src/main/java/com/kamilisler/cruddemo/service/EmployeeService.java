package com.kamilisler.cruddemo.service;

import com.kamilisler.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int Id);
    void save(Employee employee);
    void deleteById(int Id);
}
