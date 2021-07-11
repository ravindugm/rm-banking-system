package com.springboot.rmbankingsystem.service;

import com.springboot.rmbankingsystem.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findById(int theId);

    public void saveCustomer(Customer theCustomer);

    public void deleteById(int theId);
}
