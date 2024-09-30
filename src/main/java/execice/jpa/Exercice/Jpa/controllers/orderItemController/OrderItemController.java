package execice.jpa.Exercice.Jpa.controllers.orderItemController;

import execice.jpa.Exercice.Jpa.controllers.salesDTO.CategorySalesDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.OrderItemDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.ProductSalesDTO;
import execice.jpa.Exercice.Jpa.repo.sales.orderItems.OrderItemsRepo;
import execice.jpa.Exercice.Jpa.services.OrderItemService.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/order_item")
@AllArgsConstructor
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    //Gestion de rapport de vente

    @GetMapping("/reportproduct/{productId}")
    public List<OrderItemDTO> getSalesReportByProduct(@PathVariable int productId) {
        return orderItemService.getSalesReportByProduct(productId);
    }

    //Gestion statistiques

    @GetMapping("/top-products")
    public List<ProductSalesDTO> getTopSellingProducts() {
        return orderItemService.getTopSellingProducts();
    }

    @GetMapping("/top-categories")
    public List<CategorySalesDTO> getTopSellingCategories() {
        return orderItemService.getTopSellingCategories();
    }

}
