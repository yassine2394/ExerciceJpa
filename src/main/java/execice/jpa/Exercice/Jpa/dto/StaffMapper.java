package execice.jpa.Exercice.Jpa.dto;

import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    @Mapping(source = "store.storeId", target = "storeId")
    @Mapping(source = "manager.staffId", target = "managerId")
    StaffDTO staffToStaffDTO(Staff staff);

    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "managerId", target = "manager.staffId")
    Staff staffDTOToStaff(StaffDTO staffDTO);

    List<StaffDTO> staffsToStaffDTOs(List<Staff> staffs);
}