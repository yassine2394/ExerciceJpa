package execice.jpa.Exercice.Jpa.controllers.productionDTO;

import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductSalesDTO {

    private Product product;
    private int totalSales;


}
