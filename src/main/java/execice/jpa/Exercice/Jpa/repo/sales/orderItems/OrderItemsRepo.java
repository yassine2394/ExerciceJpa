package execice.jpa.Exercice.Jpa.repo.sales.orderItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemsRepo extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> findByProduct_ProductId(int productId);

    // Statistiques sur les ventes
    @Query("SELECT oi.product, COUNT(oi) AS total FROM OrderItem oi GROUP BY oi.product ORDER BY total DESC")
    List<Object[]> findTopSellingProducts();

    @Query("SELECT oi.product.category, COUNT(oi) AS total FROM OrderItem oi GROUP BY oi.product.category ORDER BY total DESC")
    List<Object[]> findTopSellingCategories();
}
