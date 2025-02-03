package com.pupspc.onlinefooddelivery.service;

import com.pupspc.onlinefooddelivery.model.Customer;
import com.pupspc.onlinefooddelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer loginCustomer(String username, String password) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null && password.equals(customer.getPassword())) {
            return customer;
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}