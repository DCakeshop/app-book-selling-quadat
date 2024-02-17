package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.CustomerResponse;
import com.example.appbookselling_quadat.entity.Customer;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getCustomerList();
    CustomerResponse getDetailCustomer(int id) throws NotFoundException;
    void createCustomer(Customer obj);
    void updateCustomer(Customer obj);
    void delete(int id);
}
