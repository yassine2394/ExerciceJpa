package execice.jpa.Exercice.Jpa.controllers.orderController;

import execice.jpa.Exercice.Jpa.controllers.salesDTO.OrderDTO;
import execice.jpa.Exercice.Jpa.services.OrderService.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/order")
@AllArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Gestion de rapport de vente

    @GetMapping("/{storeId}")
    public List<OrderDTO> getSalesReportByStore(@PathVariable int storeId) {
        return orderService.getSalesReportByStore(storeId);
    }

    @GetMapping("/reportstaff/{staffId}")
    public List<OrderDTO> getSalesReportByStaff(@PathVariable int staffId) {
        return orderService.getSalesReportByStaff(staffId);
    }

    //Gestion d'historique
    @GetMapping("/customer/{customerId}")
    public List<OrderDTO> getOrderHistoryByCustomer(@PathVariable int customerId) {
        return orderService.getOrderHistoryByCustomer(customerId);
    }

    @GetMapping("/date-range")
    public List<OrderDTO> getOrderHistoryByDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return orderService.getOrderHistoryByDateRange(startDate, endDate);
    }


}
