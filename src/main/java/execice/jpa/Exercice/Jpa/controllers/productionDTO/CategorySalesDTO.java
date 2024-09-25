package execice.jpa.Exercice.Jpa.controllers.productionDTO;

import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategorySalesDTO {

    private Category category;
    private int totalSales;
}
