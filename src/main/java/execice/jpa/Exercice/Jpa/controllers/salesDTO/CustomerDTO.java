package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import lombok.Data;

@Data
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zipCode;

}
