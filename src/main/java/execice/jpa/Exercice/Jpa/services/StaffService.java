package execice.jpa.Exercice.Jpa.services;

import execice.jpa.Exercice.Jpa.dto.StaffDTO;
import execice.jpa.Exercice.Jpa.dto.StaffMapper;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.StaffRepo;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import execice.jpa.Exercice.Jpa.repo.sales.stores.StoreRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StaffService {
    private final StaffRepo staffRepo;
    private final StoreRepo storeRepo;
    private final StaffMapper staffMapper = StaffMapper.INSTANCE;

    public StaffDTO addStaff(StaffDTO staffDTO) {
        Staff staff = staffMapper.staffDTOToStaff(staffDTO);

        if (staffDTO.getStoreId() != null) {
            Store store = storeRepo.findById(staffDTO.getStoreId())
                    .orElseThrow(() -> new RuntimeException("Store not found"));
            staff.setStore(store);
        }

        if (staffDTO.getManagerId() != null) {
            Staff manager = staffRepo.findById(staffDTO.getManagerId())
                    .orElseThrow(() -> new RuntimeException("Manager not found"));
            staff.setManager(manager);
        }

        return staffMapper.staffToStaffDTO(staffRepo.save(staff));
    }

    public StaffDTO updateStaff(int id, StaffDTO staffDTO) {
        if (!staffRepo.existsById(id)) {
            throw new RuntimeException("Employé non trouvé");
        }
        Staff staff = staffMapper.staffDTOToStaff(staffDTO);
        staff.setStaffId(id);

        if (staffDTO.getStoreId() != null) {
            Store store = storeRepo.findById(staffDTO.getStoreId())
                    .orElseThrow(() -> new RuntimeException("Store not found"));
            staff.setStore(store);
        } else {
            staff.setStore(null);
        }

        if (staffDTO.getManagerId() != null) {
            Staff manager = staffRepo.findById(staffDTO.getManagerId())
                    .orElseThrow(() -> new RuntimeException("Manager not found"));
            staff.setManager(manager);
        } else {
            staff.setManager(null);
        }

        return staffMapper.staffToStaffDTO(staffRepo.save(staff));
    }

    public void deleteStaffById(int id) {
        if (!staffRepo.existsById(id)) { throw new RuntimeException("Employé non trouvé"); }
        staffRepo.deleteById(id);
    }

    public StaffDTO findStaffById(int id) {
        return staffRepo.findById(id).map(staffMapper::staffToStaffDTO).orElseThrow(() -> new RuntimeException("Employé non trouvé"));
    }

    public List<StaffDTO> findAllStaffs() {
        return staffMapper.staffsToStaffDTOs(staffRepo.findAll());
    }

}
