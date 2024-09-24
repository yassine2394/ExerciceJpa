package execice.jpa.Exercice.Jpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StaffDTO {
    int staffId;
    String firstName;
    String lastName;
    String email;
    String phone;
    byte active;
    Integer storeId;
    Integer managerId;
}