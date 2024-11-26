package com.imaginary_store.registration.controller;

import com.imaginary_store.registration.exceptions.EmptyRequestBodyException;
import com.imaginary_store.registration.exceptions.EntityNotFoundException;
import com.imaginary_store.registration.services.customer.AddCustomer;
import com.imaginary_store.registration.services.customer.GetCustomer;
import dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

import static com.imaginary_store.registration.constants.ServiceConstants.ID;
import static com.imaginary_store.registration.constants.ServiceConstants.RESULT;

@RestController
public class UserRegistrationApi {
    @Autowired
    private AddCustomer addCustomer;

    @Autowired
    private GetCustomer getCustomer;

    @PostMapping(value = "/registration")
    public ResponseEntity<Map<String, Object>> addCustomer(@RequestBody CustomerDTO customerDTO) throws EmptyRequestBodyException {
        Map<String, Object> response = addCustomer.addNewCustomer(customerDTO);
        String responseOutput = String.format("[id: %s, result: %s]", response.get(ID), response.get(RESULT));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/registeredUsers/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable(name = "id") String id) throws EntityNotFoundException {
        CustomerDTO customerDTO = getCustomer.getCustomerById(id);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
}
