package execice.jpa.Exercice.Jpa.services.IServices;
import execice.jpa.Exercice.Jpa.controllers.payloads.StaffPayload;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.StaffDTO;

import java.util.List;

public interface IStaffService {


    //Gestion des Staffs
    StaffDTO createStaff(StaffPayload payload);

    StaffDTO getStaffById(int customerId);
    List<StaffDTO> getAllStaff();
    StaffDTO updateStaff(int staffId, StaffDTO staffDTO);
    void deleteStaff(int staffId);
    StaffDTO assignManager(StaffPayload manager);

}
