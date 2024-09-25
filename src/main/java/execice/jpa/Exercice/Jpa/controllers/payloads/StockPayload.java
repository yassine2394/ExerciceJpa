package execice.jpa.Exercice.Jpa.controllers.payloads;

import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import lombok.Data;

@Data
public class StockPayload {
    private int storeId;
    private int productId;
    private int quantity;

}
