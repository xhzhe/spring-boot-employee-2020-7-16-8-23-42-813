package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Data.Employees;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getEmployees() {
        return Employees.employees;
    }

    @GetMapping("/{employeeID}")
    public Employee getEmployee(@PathVariable Integer employeeID) {
        return Employees.employees.stream().filter(employee -> employee.getId().equals(employeeID)).findFirst().orElse(null);
    }
}
