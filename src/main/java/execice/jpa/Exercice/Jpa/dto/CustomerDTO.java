package execice.jpa.Exercice.Jpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    int customerId;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String street;
    String city;
    String state;
    String zipCode;
}
