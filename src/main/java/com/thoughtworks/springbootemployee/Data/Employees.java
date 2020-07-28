package com.thoughtworks.springbootemployee.Data;

import com.thoughtworks.springbootemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    public static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "alex", 18, "male"));
        employees.add(new Employee(2, "green", 18, "male"));
        employees.add(new Employee(3, "hello", 18, "female"));
        employees.add(new Employee(4, "zach", 18, "male"));
    }

}
