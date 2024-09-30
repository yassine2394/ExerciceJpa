package execice.jpa.Exercice.Jpa.controllers.salesDTO;

import execice.jpa.Exercice.Jpa.controllers.payloads.StorePayload;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
    StoreDTO toDTO(Store store);
    Store toEntity(StorePayload payload);
}
