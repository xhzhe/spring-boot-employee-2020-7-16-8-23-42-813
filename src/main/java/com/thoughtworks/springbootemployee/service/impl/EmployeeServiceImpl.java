package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.Data.Employees;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public boolean update(Employee employee) {
        Employee employeeInDatabase = Employees.employees.stream()
                .filter(staff -> staff.getId().equals(employee.getId()))
                .findFirst()
                .orElse(null);
        if (employeeInDatabase == null) {
            return false;
        }
        if (employee.getAge() != null) {
            employeeInDatabase.setAge(employee.getAge());
        }
        if (employee.getGender() != null) {
            employeeInDatabase.setGender(employee.getGender());
        }
        if (employee.getName() != null) {
            employeeInDatabase.setName(employee.getName());
        }
        return true;
    }

    @Override
    public String delete(Integer employeeID) {
        Employee employeeInDatabase = Employees.employees.stream()
                .filter(staff -> staff.getId().equals(employeeID))
                .findFirst()
                .orElse(null);
        if (employeeInDatabase == null) {
            return "not find";
        }
        Employees.employees.remove(employeeInDatabase);
        return "success";
    }
}
