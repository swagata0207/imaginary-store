package com.imaginary_store.registration.utility;

import com.imaginary_store.registration.exceptions.EmptyRequestBodyException;
import dto.CustomerDTO;

public class CustomerValidationUtility {

    public static void validateCustomer(CustomerDTO customerDTO) throws EmptyRequestBodyException {

        if (customerDTO.getCustomerName() == null || customerDTO.getCustomerName().isBlank()) {
            throw new EmptyRequestBodyException("Name should not be empty/blank/null");
        } else if (customerDTO.getCustomerEmail() == null || customerDTO.getCustomerEmail().isBlank()) {
            throw new EmptyRequestBodyException("Email should not be empty/blank/null");
        } else if (customerDTO.getCustomerPhoneNo() == null || customerDTO.getCustomerPhoneNo().isBlank()) {
            throw new EmptyRequestBodyException("PhoneNo should not be empty/blank/null");
        }
    }
}
