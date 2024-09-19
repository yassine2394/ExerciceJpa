package execice.jpa.Exercice.Jpa.repo.sales.customers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepo extends JpaRepository<Customer, Integer> {

    Customer findByCustomerId(int customerId);
}
