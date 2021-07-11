package com.springboot.rmbankingsystem.service;

import com.springboot.rmbankingsystem.dao.CustomerRepository;
import com.springboot.rmbankingsystem.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(int theId) {
        return null;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {

    }
}
