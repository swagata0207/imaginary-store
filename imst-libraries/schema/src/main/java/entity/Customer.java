package entity;

import customclases.Address;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNo;
    private Address customerAddress;
}
