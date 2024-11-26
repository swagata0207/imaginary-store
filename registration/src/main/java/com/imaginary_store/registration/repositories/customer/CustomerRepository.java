package com.imaginary_store.registration.repositories.customer;

import entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{'customerId': ?0 }")
    public Optional<Customer> findCustomerByCustomerId(String customerId);

    @Query("{'customerEmail': ?0 }")
    public Optional<Customer> findCustomerByCustomerEmail(String customerEmail);

    @Query("{'customerPhoneNo': ?0 }")
    public Optional<Customer> findCustomerByCustomerPhoneNo(String customerPhoneNo);
}
