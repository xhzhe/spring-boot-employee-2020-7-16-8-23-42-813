package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.Data.Employees;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String SUCCESS = "success";
    private static final String NOT_FIND = "not find";
    private static final String ID_INPUT_WRONG_MESSAGE = "id input is forbidden";

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
            return NOT_FIND;
        }
        Employees.employees.remove(employeeInDatabase);
        return SUCCESS;
    }

    @Override
    public String add(Employee employee) {
        if (employee.getId() != null) {
            return ID_INPUT_WRONG_MESSAGE;
        }
        Employees.addEmployee(employee);
        return SUCCESS;
    }
}
