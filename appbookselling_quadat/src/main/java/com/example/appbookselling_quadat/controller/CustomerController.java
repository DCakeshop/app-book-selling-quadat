package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.CustomerResponse;
import com.example.appbookselling_quadat.entity.Customer;
import com.example.appbookselling_quadat.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/all")
    public List<CustomerResponse> getAllCustomer(){
        return customerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public CustomerResponse getDetailCustomer(@PathVariable int id){
        return customerService.getDetailCustomer(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }
}
