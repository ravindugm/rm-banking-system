package com.springboot.rmbankingsystem.dao;

import com.springboot.rmbankingsystem.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
