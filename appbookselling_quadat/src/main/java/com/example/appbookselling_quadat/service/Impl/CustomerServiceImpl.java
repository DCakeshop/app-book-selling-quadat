package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.CustomerResponse;
import com.example.appbookselling_quadat.entity.Customer;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.CustomerMapper;
import com.example.appbookselling_quadat.repository.CustomerRepository;
import com.example.appbookselling_quadat.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public List<CustomerResponse> getCustomerList() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getDetailCustomer(int id) throws NotFoundException {
        Customer customer = customerRepository.findCustomerById(id);
        if (Objects.isNull(customer)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        return CustomerMapper.convertToResponse(customer);
    }

    @Override
    public void createCustomer(Customer obj) {
        customerRepository.save(obj);
    }

    @Override
    public void updateCustomer(Customer obj) {
        customerRepository.save(obj);
    }

    @Override
    public void delete(int id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (Objects.isNull(customer)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        else {
            customerRepository.delete(customer);
        }
    }
}
