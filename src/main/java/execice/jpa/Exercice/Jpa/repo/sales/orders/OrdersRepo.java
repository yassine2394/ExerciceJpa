package execice.jpa.Exercice.Jpa.repo.sales.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Order, Integer> {
}
