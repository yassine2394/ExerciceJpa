package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import execice.jpa.Exercice.Jpa.controllers.payloads.StaffPayload;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    @Mapping(source = "manager.staffId", target = "manager")
    @Mapping(source = "store.storeId", target = "storeId")
    StaffDTO toDTO(Staff staff);


    @Mapping(target = "manager",ignore = true)
    @Mapping(target = "store",ignore = true)
    Staff toEntity(StaffPayload staffPayload);


    @Named("mapManager")
    default Staff mapManager(int managerId) {
        Staff manager = new Staff();
        manager.setStaffId(managerId);
        return manager;
    }




}
