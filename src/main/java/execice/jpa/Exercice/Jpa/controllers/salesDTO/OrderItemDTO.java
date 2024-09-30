package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import execice.jpa.Exercice.Jpa.controllers.productionDTO.ProductDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {

    private int orderId;
    private int itemId;
    private int quantity;
    private double listPrice;
    private BigDecimal discount;
    private int productId;
}
