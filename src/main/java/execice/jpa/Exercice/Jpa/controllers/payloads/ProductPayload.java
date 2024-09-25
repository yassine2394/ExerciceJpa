package execice.jpa.Exercice.Jpa.controllers.payloads;

import execice.jpa.Exercice.Jpa.repo.production.brands.Brand;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPayload {

    private String productName;
    private short modelYear;
    private BigDecimal listPrice;
    private int brandId;
    private int categoryId;
}
