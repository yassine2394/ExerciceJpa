package execice.jpa.Exercice.Jpa.repo.production.stocks;

import java.io.Serializable;

public class StockId implements Serializable {

    private int storeId;
    private int productId;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
