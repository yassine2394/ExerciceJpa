package execice.jpa.Exercice.Jpa.repo.sales.orders;

import execice.jpa.Exercice.Jpa.repo.sales.orderItems.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OrdersRepo extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.store.storeId = :storeId")
    List<Order> findOrdersByStoreId(@Param("storeId") int storeId);

    @Query("SELECT o FROM Order o WHERE o.staff.staffId = :staffId")
    List<Order> findOrdersByStaffId(@Param("staffId") int staffId);

    @Query("SELECT oi FROM OrderItem oi WHERE oi.product.productId = :productId")
    List<OrderItem> findOrderItemsByProductId(@Param("productId") int productId);


    // pour historique de commandes

    @Query("SELECT o FROM Order o WHERE o.customer.customerId = :customerId")
    List<Order> findOrdersByCustomerId(@Param("customerId") int customerId);

    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Order> findOrdersByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


}
