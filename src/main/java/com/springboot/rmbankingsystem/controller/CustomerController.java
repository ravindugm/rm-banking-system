package com.springboot.rmbankingsystem.controller;

import com.springboot.rmbankingsystem.model.Customer;
import com.springboot.rmbankingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer findById(@PathVariable int customerId) {
        Customer customer = customerService.findById(customerId);

        if (customer == null) {
            throw new RuntimeException("Customer of id " + customerId + " is not found");
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer theCustomer) {
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer thwCustomer) {
        customerService.saveCustomer(thwCustomer);

        return thwCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer theCustomer = customerService.findById(customerId);

        if (theCustomer == null) {
            throw new RuntimeException("Customer of id " + customerId + " not found");
        }

        customerService.deleteById(customerId);

        return "Delete the record of id: " + customerId;
    }

}
