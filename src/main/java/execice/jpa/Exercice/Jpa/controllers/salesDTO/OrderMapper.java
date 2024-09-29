package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import execice.jpa.Exercice.Jpa.repo.sales.orders.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "order.customer.customerId", target = "customerId")
    @Mapping(source = "order.store.storeId", target = "storeId")
    @Mapping(source = "order.staff.staffId", target = "staffId")

    OrderDTO toDTO(Order order);
    Order toEntity(OrderDTO orderDTO);
}
