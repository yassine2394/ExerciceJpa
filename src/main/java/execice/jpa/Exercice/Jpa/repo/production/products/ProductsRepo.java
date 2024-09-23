package execice.jpa.Exercice.Jpa.repo.production.products;

import execice.jpa.Exercice.Jpa.repo.sales.orderItems.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Product, Integer> {
}
