package com.imaginary_store.registration.services.customer;

import com.imaginary_store.registration.exceptions.EntityNotFoundException;
import com.imaginary_store.registration.repositories.customer.CustomerRepository;
import dto.CustomerDTO;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCustomer {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO getCustomerById(String customerId) throws EntityNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByCustomerId(customerId);

        optionalCustomer.orElseThrow(() -> new EntityNotFoundException(""));

        return CustomerDTO.prepareCustomerDTO(optionalCustomer.get());
    }

    public CustomerDTO getCustomerByEmail(String customerEmail) throws Exception {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByCustomerEmail(customerEmail);

        optionalCustomer.orElseThrow(() -> new EntityNotFoundException(""));

        return CustomerDTO.prepareCustomerDTO(optionalCustomer.get());
    }

    public CustomerDTO getCustomerByPhoneNo(String customerPhoneNo) throws Exception {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByCustomerPhoneNo(customerPhoneNo);

        optionalCustomer.orElseThrow(() -> new EntityNotFoundException(""));

        return CustomerDTO.prepareCustomerDTO(optionalCustomer.get());
    }
}
