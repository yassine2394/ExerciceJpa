package execice.jpa.Exercice.Jpa.repo.sales.orderItems;

import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.orders.Order;
import jakarta.persistence.*;
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
    @JoinColumn (name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity",columnDefinition ="int")
    private int quantity;
    @Column(name = "list_price")
    private double listPrice;
    @Column(name = "discount")
    private BigDecimal discount;
}
