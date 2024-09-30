package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);

}
