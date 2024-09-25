package execice.jpa.Exercice.Jpa.controllers.productionDTO;

import execice.jpa.Exercice.Jpa.repo.production.brands.Brand;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private int productId;
    private String productName;
    private int modelYear;
    private BigDecimal listPrice;
    private Brand brand;
    private Category category;

}
