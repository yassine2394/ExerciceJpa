package execice.jpa.Exercice.Jpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreDTO {
    int storeId;
    String storeName;
    String phone;
    String email;
    String street;
    String city;
    String state;
    String zipCode;
}
