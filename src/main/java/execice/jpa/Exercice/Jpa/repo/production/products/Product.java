package execice.jpa.Exercice.Jpa.repo.production.products;

import execice.jpa.Exercice.Jpa.repo.production.brands.Brand;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Table(name = "products", schema = "production")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Convert(converter = VarbinaryToIntConverter.class)
    @Column(name = "model_year")
    private Integer modelYear;
    @Column(name = "list_price")
    private BigDecimal listPrice;

}
