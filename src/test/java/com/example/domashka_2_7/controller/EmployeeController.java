package com.example.domashka_2_7.controller;

import com.example.domashka_2_7.model.Employee;
import com.example.domashka_2_7.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(String firstName,
                                String lastName,
                                int department,
                                int workersSalary) {

        return employeeService.addEmployee(firstName, lastName, department, workersSalary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(String firstName,
                                   String lastName,
                                   int department,
                                   int workersSalary) {

        return employeeService.deleteEmployee(firstName, lastName, department, workersSalary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(String firstName,
                                 String lastName,
                                 int department,
                                 int workersSalary) {

        return employeeService.getEmployee(firstName, lastName, department, workersSalary);
    }

    @GetMapping
    public Collection<Employee> allEmployee() {

        return employeeService.findAll();
    }
}