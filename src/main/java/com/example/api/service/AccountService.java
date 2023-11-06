package com.example.api.service;

import com.example.api.domain.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUserName(String username);
    List<Account> getAccounts();
}
