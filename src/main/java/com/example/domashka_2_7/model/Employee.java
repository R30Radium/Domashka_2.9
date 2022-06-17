package com.example.domashka_2_5.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {


    @JsonProperty("firstName")
    private final String name;
    @JsonProperty("lastName")
    private final String surname;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    public String toString() {
        return String.format("ФИ: %s %s", surname, name);
    }
}