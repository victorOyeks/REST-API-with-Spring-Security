package com.example.sprintapiwithsecurity.service.imp;

import com.example.sprintapiwithsecurity.model.Employee;
import com.example.sprintapiwithsecurity.repository.InMemoryEmployeeRepository;
import com.example.sprintapiwithsecurity.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Qualifier(value = "inMemory")
public class InMemoryEmployeeServiceImpl implements EmployeeService {

    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        inMemoryEmployeeRepository.addEmployee(employee);
        return employee;
    }

    @Override
    public List<Employee> getALlEmployees() {
        return inMemoryEmployeeRepository.getAllEmployees();
    }

    @Override
    public Employee findById(Long id) {
        return inMemoryEmployeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee,Long id) {
//        Optiona inMemoryEmployeeRepository.updateEmployee()
//        if (existingEmployee.isPresent()) {
//            Employee oldEmployee = existingEmployee.get();
//            oldEmployee.setEmail(employee.getEmail());
//            oldEmployee.setFirstName(employee.getFirstName());
//            oldEmployee.setLastName(employee.getLastName());
//            return oldEmployee;
//        } else {
//            throw new RuntimeException("Employee not found");
//        }
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        return inMemoryEmployeeRepository.deleteEmployee(id);
    }
}
