package com.pupspc.onlinefooddelivery.controller;

import com.pupspc.onlinefooddelivery.model.Customer;
import com.pupspc.onlinefooddelivery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody Customer customer) {
        Customer loggedInCustomer = customerService.loginCustomer(customer.getUsername(), customer.getPassword());
        if (loggedInCustomer != null) {
            return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid username or password\"}");
    }
}