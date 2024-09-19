package execice.jpa.Exercice.Jpa.repo.sales.orders;

import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders",schema = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @Column(name = "order_id")
    int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    Store store;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    Staff staff;

    @Column(name="order_status")
    String orderStatus;

    @Column(name="order_date")
    LocalDate orderDate;

    @Column(name="required_date")
    LocalDate requiredDate;

    @Column(name="shipped_date")
    LocalDate shippedDate;

}
