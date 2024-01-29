package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerById(int id);
}
