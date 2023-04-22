package com.example.sprintapiwithsecurity.repository;

import com.example.sprintapiwithsecurity.model.Account;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
