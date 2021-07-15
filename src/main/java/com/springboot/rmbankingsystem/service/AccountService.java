package com.springboot.rmbankingsystem.service;

import com.springboot.rmbankingsystem.model.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public Account findById(int theId);

    public void saveAccount(Account theAccount);

    public void deleteById(int theId);
}
