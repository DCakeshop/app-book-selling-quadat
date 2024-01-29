package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.CustomerResponse;
import com.example.appbookselling_quadat.entity.Customer;

public class CustomerMapper {
    public static CustomerResponse convertToResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setUserId(customer.getUserId());
        return customerResponse;
    }
}
