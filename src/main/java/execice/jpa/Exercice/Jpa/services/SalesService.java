package execice.jpa.Exercice.Jpa.services;

import execice.jpa.Exercice.Jpa.dto.CustomerDTO;
import execice.jpa.Exercice.Jpa.dto.CustomerMapper;
import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import execice.jpa.Exercice.Jpa.repo.sales.customers.CustomersRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalesService {
    private final CustomersRepo customersRepo;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        return customerMapper.customerToCustomerDTO(customersRepo.save(customer));
    }

    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
        if (!customersRepo.existsById(id)) {
            return null;
        }
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setCustomerId(id);
        return customerMapper.customerToCustomerDTO(customersRepo.save(customer));
    }

    public void deleteCustomer(int customerId) {
        customersRepo.deleteById(customerId);
    }

    public CustomerDTO findCustomerById(int customerId) {
        Optional<Customer> customerOptional = customersRepo.findById(customerId);
        return customerOptional.map(customerMapper::customerToCustomerDTO).orElse(null);
    }

    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customers = customersRepo.findAll();
        return customerMapper.customersToCustomerDTOs(customers);
    }

    public List<CustomerDTO> findCustomersByCityOrZipCode(String city, String zipCode) {
        List<Customer> customers;
        if (city != null && zipCode != null) {
            customers = customersRepo.findByCityAndZipCode(city, zipCode);
        } else if (city != null) {
            customers = customersRepo.findByCity(city);
        } else if (zipCode != null) {
            customers = customersRepo.findByZipCode(zipCode);
        } else {
            customers = customersRepo.findAll();
        }
        return customerMapper.customersToCustomerDTOs(customers);
    }
}