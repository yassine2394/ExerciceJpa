package execice.jpa.Exercice.Jpa.controllers.payloads;

import lombok.Data;

@Data
public class StorePayload {

    private String storeName;
    private String phone;
    private  String email;
    private String street;
    private String city;
    private String state;
    private int zipCode;
}
