package com.kamilisler.cruddemo.dao;

import com.kamilisler.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // we get this crud methods with free !!
}
