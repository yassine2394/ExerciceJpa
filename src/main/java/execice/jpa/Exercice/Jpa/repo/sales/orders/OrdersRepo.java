package execice.jpa.Exercice.Jpa.repo.sales.orders;

import execice.jpa.Exercice.Jpa.repo.sales.orderItems.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrdersRepo extends JpaRepository<Order, Integer> {

    // Trouver les commandes par storeId
    List<Order> findByStore_StoreId(int storeId);

    // Trouver les commandes par staffId
    List<Order> findByStaff_StaffId(int staffId);

    // Historique des commandes par customerId
    List<Order> findByCustomer_CustomerId(int customerId);

    // Historique des commandes par plage de dates
    List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

}
