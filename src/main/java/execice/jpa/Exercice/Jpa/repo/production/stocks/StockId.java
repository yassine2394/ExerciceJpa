package execice.jpa.Exercice.Jpa.repo.production.stocks;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockId implements Serializable {

    private int storeId;
    private int productId;


}
