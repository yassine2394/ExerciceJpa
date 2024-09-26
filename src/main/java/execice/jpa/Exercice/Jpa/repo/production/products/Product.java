package execice.jpa.Exercice.Jpa.repo.production.products;

import execice.jpa.Exercice.Jpa.repo.production.brands.Brand;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products", schema = "production")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    int productId;

    @Column(name = "product_name", nullable = false)
    String productName;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    @Column(name = "model_year", nullable = false)
    short modelYear;

    @Column(name = "list_price", nullable = false)
    BigDecimal listPrice;

}
