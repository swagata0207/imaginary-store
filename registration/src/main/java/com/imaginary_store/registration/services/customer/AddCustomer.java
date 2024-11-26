package com.imaginary_store.registration.services.customer;

import com.imaginary_store.registration.exceptions.EmptyRequestBodyException;
import com.imaginary_store.registration.repositories.customer.CustomerRepository;
import com.imaginary_store.registration.utility.CustomerValidationUtility;
import com.imaginary_store.registration.utility.IdGenerator;
import dto.CustomerDTO;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.imaginary_store.registration.constants.ServiceConstants.ID;
import static com.imaginary_store.registration.constants.ServiceConstants.RESULT;

@Service
public class AddCustomer {
    @Autowired
    private CustomerRepository customerRepository;

    Map<String, Object> functionReturn = new HashMap<>();

    public Map<String, Object> addNewCustomer (CustomerDTO customerDTO) throws EmptyRequestBodyException {
        if(null != customerDTO) {
            CustomerValidationUtility.validateCustomer(customerDTO);

            Customer customer = CustomerDTO.prepareCustomerEntity(customerDTO);
            String id = IdGenerator.generateId(customerRepository);
            customer.setCustomerId(id);

            functionReturn.put(ID, id);
            functionReturn.put(RESULT, "SUCCESS");

            customerRepository.save(customer);
        } else {
            functionReturn.put(RESULT, "FAILURE");
            throw new EmptyRequestBodyException();
        }
        return functionReturn;
    }
}
