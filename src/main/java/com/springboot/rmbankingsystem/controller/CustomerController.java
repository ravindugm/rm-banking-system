package com.springboot.rmbankingsystem.controller;

import com.springboot.rmbankingsystem.model.Customer;
import com.springboot.rmbankingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customerRegistrationForm")
    public String showCustomerRegistrationForm(Model theModel) {

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer/customer-registration-form";
    }

    @PostMapping("/registerCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/bank/showCustomerRegistrationSuccessful";
    }

    @GetMapping("/showCustomerRegistrationSuccessful")
    public String showEmployeeRegistrationSuccessfulForm() {
        return "customer/customer-registration-complete-form";
    }
}
