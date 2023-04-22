package com.example.sprintapiwithsecurity.repository;

import com.example.sprintapiwithsecurity.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1L, "John", "Smith", "john@gmail.com"));
        DATABASE.add(new Employee(2L, "Alex", "Raymond", "alex@gmail.com"));
        DATABASE.add(new Employee(3L, "David", "Cameroon", "david@gmail.com"));
    }

    public Employee addEmployee (Employee employee) {
         DATABASE.add(employee);
         return employee;
    }

    public List<Employee> getAllEmployees () {
        return List.copyOf(DATABASE);
    }

    public Employee findById (Long id) {
        return DATABASE.stream().filter(emp -> id.equals(emp.getId())).findFirst().orElseThrow();
    }

    public Optional<Employee> updateEmployee(Employee employee, Long id) {
        return DATABASE.stream().filter(emp -> id.equals(emp.getId())).findFirst();
    }

    public Boolean deleteEmployee (Long id) {
        Employee employee = DATABASE.stream().filter(emp -> id.equals(emp.getId())).findFirst().orElseThrow();
        DATABASE.remove(employee);
        return Boolean.TRUE;
    }
}
