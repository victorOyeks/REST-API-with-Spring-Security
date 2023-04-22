package com.example.sprintapiwithsecurity.repository;

import com.example.sprintapiwithsecurity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmployeeRepository extends JpaRepository <Employee, Long> {
}
