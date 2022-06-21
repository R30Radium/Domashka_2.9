package com.example.domashka_2_7.Controller;

import com.example.domashka_2_7.Exception.EmployeeAlreadyAddedException;
import com.example.domashka_2_7.Exception.EmployeeNotFoundException;
import com.example.domashka_2_7.Exception.EmployeeStorageIsFullException;
import com.example.domashka_2_7.model.Employee;

import com.example.domashka_2_7.service.EmployeeService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.util.pattern.PathPattern;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee) {
        return employee.getFirstName() + employee.getLastName();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int workersSalary) {

        Employee employee = new Employee(firstName, lastName, department, workersSalary);

        if (employees.containsKey(getKey(employee))) {

            throw new EmployeeAlreadyAddedException();
        }

        if (employees.size() < LIMIT) {
            return employees.put(getKey(employee), employee);

        }
        throw new EmployeeStorageIsFullException();
    }


    @Override
    public Employee deleteEmployee(String firstName, String lastName, int department, int workersSalary) {
        Employee employee = new Employee(firstName, lastName, department, workersSalary);
        if (!employees.containsKey(getKey(employee))) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(getKey(employee));
    }


    @Override
    public Employee getEmployee(String firstName, String lastName, int department, int workersSalary) {
        Employee employee = new Employee(firstName, lastName, department, workersSalary);
        if (!employees.containsKey(getKey(employee))) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }
}