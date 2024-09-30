package execice.jpa.Exercice.Jpa.services.OrderService;

import execice.jpa.Exercice.Jpa.controllers.salesDTO.OrderDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.OrderMapper;
import execice.jpa.Exercice.Jpa.repo.sales.orders.Order;
import execice.jpa.Exercice.Jpa.repo.sales.orders.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrdersRepo orderRepo;

    private  final OrderMapper orderMapper = OrderMapper.INSTANCE;

    //Gestion de rapport de vente

    public List<OrderDTO> getSalesReportByStore(int storeId) {
        List<Order> orders = orderRepo.findByStore_StoreId(storeId);
        return orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getSalesReportByStaff(int staffId) {
        List<Order> orders = orderRepo.findByStaff_StaffId(staffId);
        return orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    //Gestion d'historique
    public List<OrderDTO> getOrderHistoryByCustomer(int customerId) {
        List<Order> orders = orderRepo.findByCustomer_CustomerId(customerId);
        return orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrderHistoryByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Order> orders = orderRepo.findByOrderDateBetween(startDate, endDate);
        return orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }


}
