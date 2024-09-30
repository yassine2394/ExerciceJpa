package execice.jpa.Exercice.Jpa.repo.sales.customers;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "First name cannot be blank")
    @Size(max = 50, message = "First name must be less than or equal to 50 characters")
    @Column(name = "first_name")
    String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 50, message = "Last name must be less than or equal to 50 characters")
    @Column(name = "last_name")
    String lastName;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    @Column(name = "phone")
    String phoneNumber;

    @Email(message = "Email should be valid")
    @Column(name = "email")
    String email;

    @Column(name = "street")
    String street;

    @NotBlank(message = "City cannot be blank")
    @Column(name = "city")
    String city;

    @Column(name = "state")
    String state;

    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip code is invalid")
    @Column(name = "zip_code")
    String zipCode;

}
