package execice.jpa.Exercice.Jpa.controllers.payloads;

import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import lombok.Data;

@Data
public class StaffPayload {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean active;
    private int storeId;
    private int managerId;
}
