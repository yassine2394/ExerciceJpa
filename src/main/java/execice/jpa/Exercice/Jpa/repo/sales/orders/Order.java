package execice.jpa.Exercice.Jpa.repo.sales.orders;

import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "Customer must not be null")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Min(value = 0, message = "Order status must be at least 0")
    @Max(value = 5, message = "Order status must be at most 5")
    @Column(name = "order_status", columnDefinition ="int")
    private int orderStatus;

    @NotNull(message = "Order date must not be null")
    @PastOrPresent(message = "Order date must be in the past or present")
    @Column(name = "order_date")
    private LocalDate orderDate;

    @NotNull(message = "Required date must not be null")
    @FutureOrPresent(message = "Required date must be in the present or future")
    @Column(name = "required_date")
    private LocalDate requiredDate;

    @FutureOrPresent(message = "Shipped date must be in the present or future")
    @Column(name = "shipped_date")
    private  LocalDate shippedDate;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}
