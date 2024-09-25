package execice.jpa.Exercice.Jpa.controllers.productionDTO;

import execice.jpa.Exercice.Jpa.controllers.payloads.ProductPayload;
import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);
    Product toEntity(ProductPayload payload);
}
