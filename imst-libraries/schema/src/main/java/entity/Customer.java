package entity;

import customclases.Address;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {

    @Id
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNo;
    private Address customerAddress;
}
