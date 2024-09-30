package execice.jpa.Exercice.Jpa.repo.production.stocks;

import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Store ID cannot be null")
    @Column(name = "store_id")
    private int storeId;

    @Id
    @NotNull(message = "Product ID cannot be null")
    @Column(name = "product_id")
    private int productId;

    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    @Column(name = "quantity",columnDefinition ="int")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;



}
