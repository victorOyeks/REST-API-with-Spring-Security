package com.example.sprintapiwithsecurity.service;

import com.example.sprintapiwithsecurity.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee (Employee employee);
    List<Employee> getALlEmployees();
    Employee findById(Long id);
    void updateEmployee(Employee employee, Long id);
    Boolean deleteEmployee(Long id);
}
