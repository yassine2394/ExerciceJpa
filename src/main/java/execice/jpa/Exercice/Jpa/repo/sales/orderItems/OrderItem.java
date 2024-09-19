package execice.jpa.Exercice.Jpa.repo.sales.orderItems;

import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.orders.Order;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_Items",schema = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem {
    @Id
    @Column(name = "item_id")
    int itemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "list_price")
    double listPrice;

    @Column(name = "discount")
    double discount;

}
