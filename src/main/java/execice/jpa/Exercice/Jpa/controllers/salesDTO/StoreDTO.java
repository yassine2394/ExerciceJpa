package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StoreDTO {
    private int storeId;
    private String storeName;
    private String phone;
    private  String email;
    private String street;
    private String city;
    private String state;
    private int zipCode;
}
