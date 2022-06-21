package com.example.domashka_2_7.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import org.springframework.web.util.pattern.PathPattern;
public class Employee {

    private final String firstName;
    private final String lastName;
    private final int department;
    private final int workersSalary;

    public Employee(String firstName, String lastName, int department, int workersSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.workersSalary = workersSalary;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getWorkersSalary() {
        return workersSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", workersSalary=" + workersSalary +
                '}';
    }
}