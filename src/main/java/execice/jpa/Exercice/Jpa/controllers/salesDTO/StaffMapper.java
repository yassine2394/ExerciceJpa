package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import execice.jpa.Exercice.Jpa.controllers.payloads.StaffPayload;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    StaffDTO toDTO(Staff staff);
    Staff toEntity(StaffPayload staffPayload);




}
