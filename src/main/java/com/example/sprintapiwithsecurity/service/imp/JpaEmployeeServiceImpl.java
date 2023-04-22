package com.example.sprintapiwithsecurity.service.imp;

import com.example.sprintapiwithsecurity.model.Employee;
import com.example.sprintapiwithsecurity.repository.JpaEmployeeRepository;
import com.example.sprintapiwithsecurity.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value = "mySQLEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getALlEmployees() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public void updateEmployee(Employee employee, Long id) {

    }

    @Override
    public Boolean deleteEmployee(Long id) {
        jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
