package com.springboot.rmbankingsystem.controller;

import com.springboot.rmbankingsystem.model.Account;
import com.springboot.rmbankingsystem.model.Customer;
import com.springboot.rmbankingsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/accounts/{accountId}")
    public Account findById(@PathVariable int accountId) {
        Account account = accountService.findById(accountId);

        if (account == null) {
            throw new RuntimeException("Account of id " + accountId + " is not found");
        }

        return account;
    }

    @PostMapping("/accounts")
    public Account saveAccount(@RequestBody Account theAccount) {
        theAccount.setId(0);

        accountService.saveAccount(theAccount);

        return theAccount;
    }

    @PutMapping("/accounts")
    public Account updateCustomer(@RequestBody Account theAccount) {
        accountService.saveAccount(theAccount);

        return theAccount;
    }

    @DeleteMapping("/accounts/{accountId}")
    public String deleteCustomer(@PathVariable int accountId) {
        Account theAccount = accountService.findById(accountId);

        if (theAccount == null) {
            throw new RuntimeException("Customer of id " + accountId + " not found");
        }

        accountService.deleteById(accountId);

        return "Delete the record of id: " + accountId;
    }

}
