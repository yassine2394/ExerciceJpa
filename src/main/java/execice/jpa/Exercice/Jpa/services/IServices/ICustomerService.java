package execice.jpa.Exercice.Jpa.services.IServices;

import execice.jpa.Exercice.Jpa.controllers.salesDTO.CustomerDTO;

import java.util.List;

public interface ICustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerById(int customerId);
    List<CustomerDTO> getAllCustomers(String city, String zipCode);
    CustomerDTO updateCustomer(int customerId, CustomerDTO customerDTO);
    void deleteCustomer(int customerId);
}
