package execice.jpa.Exercice.Jpa.repo.sales.orders;

import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "orders",schema = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private  int orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "order_status", columnDefinition ="int")
    private int orderStatus;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "required_date")
    private LocalDate requiredDate;
    @Column(name = "shipped_date")
    private  LocalDate shippedDate;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}
