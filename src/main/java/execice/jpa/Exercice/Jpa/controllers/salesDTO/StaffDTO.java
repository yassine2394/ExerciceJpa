package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import lombok.Data;

@Data
public class StaffDTO {

    private int staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean active;
    private Store store;
    private Staff staff;
}
