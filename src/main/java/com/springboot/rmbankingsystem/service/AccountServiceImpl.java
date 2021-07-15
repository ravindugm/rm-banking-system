package com.springboot.rmbankingsystem.service;

import com.springboot.rmbankingsystem.dao.AccountRepository;
import com.springboot.rmbankingsystem.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int theId) {
        Optional<Account> results = accountRepository.findById(theId);

        Account theAccount = null;

        if (results.isPresent()) {
            theAccount = results.get();
        } else {
            throw new RuntimeException("Did not find account id:" + theId);
        }

        return theAccount;
    }

    @Override
    public void saveAccount(Account theAccount) {
        accountRepository.save(theAccount);
    }

    @Override
    public void deleteById(int theId) {
        accountRepository.deleteById(theId);
    }
}
