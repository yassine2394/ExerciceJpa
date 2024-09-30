package execice.jpa.Exercice.Jpa.controllers.productionDTO;

import execice.jpa.Exercice.Jpa.controllers.payloads.ProductPayload;
import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.category.categoryId", target = "categoryId")
    @Mapping(source = "product.brand.brandId", target = "brandId")
    ProductDTO toDTO(Product product);
    Product toEntity(ProductPayload payload);
}
