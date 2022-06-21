package com.example.domashka_2_7.Controller;

import com.example.domashka_2_7.Exception.EmployeeNotFoundException;
import com.example.domashka_2_7.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.util.pattern.PathPattern;


@Service

public class DepartmentServiceImlp {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImlp(EmployeeServiceImpl employeeService) {

        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> allEmployee() {

        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.toList()));
    }

    public Employee departmentMinSalary(int department) {

        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getWorkersSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee departmentMaxSalary(int department) {

        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getWorkersSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public List<Employee> departmentWorkers(int department) {

        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }
}
