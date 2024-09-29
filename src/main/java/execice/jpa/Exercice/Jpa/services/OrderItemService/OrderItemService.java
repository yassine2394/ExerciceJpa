package execice.jpa.Exercice.Jpa.services.OrderItemService;

import execice.jpa.Exercice.Jpa.controllers.salesDTO.CategorySalesDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.OrderItemDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.OrderItemMapper;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.ProductSalesDTO;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.orderItems.OrderItem;
import execice.jpa.Exercice.Jpa.repo.sales.orderItems.OrderItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemsRepo orderItemsRepo;
    private  final OrderItemMapper orderItemMapper = OrderItemMapper.INSTANCE;

    //Gestion des rapports de vente
    public List<OrderItemDTO> getSalesReportByProduct(int productId) {
        List<OrderItem> orderItems = orderItemsRepo.findByProduct_ProductId(productId);
        return orderItems.stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    //Gestion de statistics

    public List<ProductSalesDTO> getTopSellingProducts() {
        List<Object[]> results = orderItemsRepo.findTopSellingProducts();
        return results.stream()
                .map(result -> new ProductSalesDTO(((Product) result[0]), (Long) result[1]))
                .collect(Collectors.toList());
    }

    public List<CategorySalesDTO> getTopSellingCategories() {
        List<Object[]> results = orderItemsRepo.findTopSellingCategories();
        return results.stream()
                .map(result -> new CategorySalesDTO((Category) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }

}
