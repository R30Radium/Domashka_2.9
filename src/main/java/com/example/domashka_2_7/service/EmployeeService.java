package com.example.domashka_2_5.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.example.domashka_2_5.exception.EmployeeAlreadyAddedException;
import com.example.domashka_2_5.exception.EmployeeNotFoundException;
import com.example.domashka_2_5.exception.EmployeeStorageIsFullException;
import com.example.domashka_2_5.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final int storage = 10;

    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if(employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        if(employees.size()<storage){
            employees.add(employee);
            return employee;
        }
            throw new EmployeeStorageIsFullException();
        }

        /* for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(employees.get(i), employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            if (Objects.isNull(employees.get(i))) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            employees.set(index, employee);
        } else {

        }*/



    public Employee find(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
                return employee;
            }



        public Employee remove (String name, String surname){
            Employee employee = new Employee(name, surname);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }
                    employees.remove(employee);
                    return employee;
                }



            public List<Employee> getAll() {
                return new ArrayList<>(employees);
            }
        }