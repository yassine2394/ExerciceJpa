package execice.jpa.Exercice.Jpa.repo.sales.customers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepo extends JpaRepository<Customer, Integer> {

    Customer findByCustomerId(int customerId);
    List<Customer> findByCity(String city);
    List<Customer> findByZipCode(String zipCode);
    List<Customer> findByCityAndZipCode(String city, String zipCode);
}
