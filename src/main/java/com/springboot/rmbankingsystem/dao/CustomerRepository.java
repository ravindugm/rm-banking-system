package com.springboot.rmbankingsystem.dao;

import com.springboot.rmbankingsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
