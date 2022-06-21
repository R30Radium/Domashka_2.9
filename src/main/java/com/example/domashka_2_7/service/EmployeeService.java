package com.example.domashka_2_7.service;

import com.example.domashka_2_7.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, int workersSalary);

    Employee deleteEmployee(String firstName, String lastName, int department, int workersSalary);

    Employee getEmployee(String firstName, String lastName, int department, int workersSalary);

    Collection<Employee> findAll();

}