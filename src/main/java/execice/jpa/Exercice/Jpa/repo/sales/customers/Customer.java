package execice.jpa.Exercice.Jpa.repo.sales.customers;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers",schema = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    int customerId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "phone")
    String phoneNumber;
    @Column(name = "email")
    String email;
    @Column(name = "street")
    String street;
    @Column(name = "city")
    String city;
    @Column(name = "state")
    String state;
    @Column(name = "zip_code")
    String zipCode;

}
