package execice.jpa.Exercice.Jpa.services.customerService;

import execice.jpa.Exercice.Jpa.controllers.salesDTO.CustomerDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.CustomerMapper;
import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import execice.jpa.Exercice.Jpa.repo.sales.customers.CustomersRepo;
import execice.jpa.Exercice.Jpa.services.IServices.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomersRepo customersRepo;

    private  final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customersRepo.save(customer);
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Customer customer = customersRepo.findByCustomerId(customerId);
        return customerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers(String city, String zipCode) {
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

        return customers.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO updateCustomer(int customerId, CustomerDTO customerDTO) {


        Customer customer = customersRepo.findByCustomerId(customerId);

        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());
        customer.setStreet(customerDTO.getStreet());
        customer.setCity(customerDTO.getCity());
        customer.setState(customerDTO.getState());
        customer.setZipCode(customerDTO.getZipCode());

        customer = customersRepo.save(customer);

        return customerMapper.toDTO(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = customersRepo.findByCustomerId(customerId);
        customersRepo.delete(customer);

    }
}
