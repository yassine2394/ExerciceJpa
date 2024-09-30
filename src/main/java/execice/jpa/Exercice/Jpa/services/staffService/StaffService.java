package execice.jpa.Exercice.Jpa.services.staffService;

import execice.jpa.Exercice.Jpa.controllers.payloads.StaffPayload;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.StaffDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.StaffMapper;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.StaffRepo;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import execice.jpa.Exercice.Jpa.repo.sales.stores.StoreRepo;
import execice.jpa.Exercice.Jpa.services.IServices.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService implements IStaffService {

    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private StoreRepo storeRepo;


    private  final StaffMapper staffMapper = StaffMapper.INSTANCE;

    @Override
    public StaffDTO createStaff(StaffPayload payload) {
        //je transforme mon payload en entité
        Staff staff = staffMapper.toEntity(payload);

        Staff manager = staffRepo.findByStaffId(payload.getManager());
        staff.setManager(manager);

        Store store = storeRepo.findByStoreId(payload.getStoreId());
        staff.setStore(store);


        staff = staffRepo.save(staff);
        return  staffMapper.toDTO(staff);
    }

    @Override
    public StaffDTO getStaffById(int customerId) {
        Staff staff = staffRepo.findByStaffId(customerId);
        return staffMapper.toDTO(staff);
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        List<Staff> staffs = staffRepo.findAll();
        return staffs.stream()
                .map(staffMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public StaffDTO updateStaff(int staffId, StaffPayload payload) {

        Staff staff = staffRepo.findByStaffId(staffId);
        Staff manager = staffRepo.findByStaffId(payload.getManager());

        staff.setFirstName(payload.getFirstName());
        staff.setLastName(payload.getLastName());
        staff.setEmail(payload.getEmail());
        staff.setPhone(payload.getPhone());
        staff.setActive(payload.isActive());
        staff.setManager(manager);
        staff.setStore(staff.getStore());

        staff = staffRepo.save(staff);
        return  staffMapper.toDTO(staff);

    }

    @Override
    public void deleteStaff(int staffId) {

        Staff staff = staffRepo.findByStaffId(staffId);
        staffRepo.delete(staff);

    }

    public StaffDTO assignManager(int staffId, int managerId) {
        // Rechercher l'employé par son ID
        Staff employee = staffRepo.findById(staffId).orElse(null);
        // Rechercher le manager par son ID
        Staff manager = staffRepo.findById(managerId).orElse(null);
        // J'asigne un manager a un employée ici
        employee.setManager(manager);
        staffRepo.save(employee);
        return staffMapper.toDTO(employee);
    }


}
