package com.example.sprintapiwithsecurity.service;

import com.example.sprintapiwithsecurity.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();
}
