package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {

    private int orderId;
    private int orderStatus;  // Status comme mentionné : 1 = Pending; 2 = Processing; 3 = Rejected; 4 = Completed
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private int customerId;
    private int storeId;
    private int staffId;
    private List<OrderItemDTO> orderItems;
}
