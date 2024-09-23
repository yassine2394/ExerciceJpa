package execice.jpa.Exercice.Jpa.repo.production.stocks;

import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "stocks",schema = "production")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@IdClass(StockId.class)
public class Stock {
    @Id
    @Column(name = "store_id")
    private int storeId;
    @Id
    @Column(name = "product_id")
    private int productId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    private int quantity;
}
