package execice.jpa.Exercice.Jpa.repo.production.stocks;

import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

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
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "quantity",columnDefinition ="int")
    private int quantity;

}
