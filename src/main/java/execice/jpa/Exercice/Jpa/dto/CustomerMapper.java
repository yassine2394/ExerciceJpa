package execice.jpa.Exercice.Jpa.dto;

import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO(Customer customer);
    List<CustomerDTO> customersToCustomerDTOs(List<Customer> customers);
}
