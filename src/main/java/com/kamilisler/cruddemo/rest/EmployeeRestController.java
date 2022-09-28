package com.kamilisler.cruddemo.rest;

import com.kamilisler.cruddemo.dao.EmployeeDAO;
import com.kamilisler.cruddemo.entity.Employee;
import com.kamilisler.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // quick and dirty :  inject employee dao / const injection
    @Autowired
    public  EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    // expose "/employee" and return list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}") // like HttpGet on .net
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee==null){
            throw new RuntimeException("Hey! Employee id not found : "+ employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0); // just in case

        employeeService.save(theEmployee);
        return theEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw  new RuntimeException("Heyy! I can not find employee with id : "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "deleted employee id "+employeeId;
    }
}
