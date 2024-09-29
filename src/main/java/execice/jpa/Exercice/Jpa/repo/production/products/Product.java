package execice.jpa.Exercice.Jpa.repo.production.products;

import execice.jpa.Exercice.Jpa.repo.production.brands.Brand;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "le nom de product ne doit etre vide")
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

    @NotNull(message = "List price must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "List price must be greater than 0")
    @Column(name = "list_price")
    private BigDecimal listPrice;

}
