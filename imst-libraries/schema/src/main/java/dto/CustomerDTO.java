package dto;

import customclases.Address;
import entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNo;
    private Address customerAddress;
    public static Customer prepareCustomerEntity(CustomerDTO customerDTO) {

        return new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerEmail(),
                customerDTO.getCustomerPhoneNo(),
                customerDTO.getCustomerAddress());
    }

    public static CustomerDTO prepareCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getCustomerEmail(),
                customer.getCustomerPhoneNo(),
                customer.getCustomerAddress()
        );
    }
}
