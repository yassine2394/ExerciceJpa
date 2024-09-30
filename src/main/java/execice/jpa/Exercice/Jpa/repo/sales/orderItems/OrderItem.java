package execice.jpa.Exercice.Jpa.repo.sales.orderItems;

import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.orders.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Table(name = "order_items", schema = "sales")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {
    @Id
    @Column(name = "item_id")
    private  int itemId;

    @OneToOne
    @NotNull(message = "Order must not be null")
    @JoinColumn (name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Min(value = 1, message = "Quantity must be at least 1")
    @Column(name = "quantity",columnDefinition ="int")
    private int quantity;

    @NotNull(message = "List price must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "List price must be greater than 0")
    @Column(name = "list_price")
    private double listPrice;

    @NotNull(message = "Discount must not be null")
    @Column(name = "discount")
    private BigDecimal discount;
}
