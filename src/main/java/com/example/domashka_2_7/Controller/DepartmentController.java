package com.example.domashka_2_7.Controller;

import com.example.domashka_2_7.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.pattern.PathPattern;

import java.util.List;
import java.util.Map;

@RestController

@RequestMapping(path = "/departments")

public class DepartmentController {

    private final DepartmentServiceImlp departmentService;

    public DepartmentController(DepartmentServiceImlp departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allEmployees() {
        return departmentService.allEmployee();
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(int department) {
        return departmentService.departmentMinSalary(department);
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(int department) {
        return departmentService.departmentMaxSalary(department);
    }

    @GetMapping(path = "/workers")
    public List<Employee> departmentWorkers(int department) {
        return departmentService.departmentWorkers(department);
    }
}
