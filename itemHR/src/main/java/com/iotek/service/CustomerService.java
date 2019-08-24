package com.iotek.service;

import com.iotek.model.Customer;

public interface CustomerService {
    boolean checkName(String name);
    Customer login(Customer customer);
    void register(Customer customer);
}
