package com.iotek.dao;

import com.iotek.model.Customer;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);
    void deleCustomer(int id);
    void updateCustomer(Customer customer);
    List<Customer> queryCustomer(Customer customer);
}
