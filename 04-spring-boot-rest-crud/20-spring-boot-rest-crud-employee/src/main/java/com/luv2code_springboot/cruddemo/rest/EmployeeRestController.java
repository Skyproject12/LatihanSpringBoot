package com.luv2code_springboot.cruddemo.rest;

import com.luv2code_springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code_springboot.cruddemo.entity.Employee;
import com.luv2code_springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick and dirty: inject employee dao (use constructor injection)
    @Autowired
    public EmployeeRestController (EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return  employeeService.findAll();
    }

    // add emapping for get / employees{employeeid}
    @GetMapping("employee/{employeeid}")
    public Employee getEmployee(@PathVariable int employeeid){
        Employee theEmployee = employeeService.findById(employeeid);

        if (theEmployee == null) {
            throw new RuntimeException("Employee is not found - "+ employeeid);
        }

        return theEmployee;
    }

    // add mapping for POST /employees - Add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
