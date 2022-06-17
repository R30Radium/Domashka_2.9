package com.example.domashka_2_7.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee add(@RequestParam("firstName")String name, @RequestParam("lastName")String surname){
        return employeeService.add(name, surname);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        return employeeService.remove(name, surname);
    }

    @GetMapping("find")
    public Employee find(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        return employeeService.find(name, surname);
    }

    @GetMapping()
    public List<Employee> getAll() {
        return employeeService.getAll();
    }




}