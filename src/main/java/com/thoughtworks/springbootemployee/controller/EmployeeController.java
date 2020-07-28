package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Data.Employees;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return Employees.employees;
    }

    @GetMapping("/{employeeID}")
    public Employee getEmployee(@PathVariable Integer employeeID) {
        return Employees.employees.stream().filter(employee -> employee.getId().equals(employeeID)).findFirst().orElse(null);
    }

    @PutMapping
    public String updateEmployee(@RequestBody Employee employee) {
        if (employee.getId() == null) {
            return "ID is empty";
        }
        return employeeService.update(employee) ? "success" : "fail";
    }
}
