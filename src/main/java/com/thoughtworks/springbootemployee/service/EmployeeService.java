package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService {
    boolean update(Employee employee);
}