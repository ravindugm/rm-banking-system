package com.springboot.rmbankingsystem.service;

import com.springboot.rmbankingsystem.dao.CustomerRepository;
import com.springboot.rmbankingsystem.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> results = customerRepository.findById(theId);

        Customer theCustomer = null;

        if (results.isPresent()) {
            theCustomer = results.get();
        } else {
            throw new RuntimeException("Did not find customer id:" + theId);
        }

        return theCustomer;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}
