package execice.jpa.Exercice.Jpa.controllers.productionDTO;

import execice.jpa.Exercice.Jpa.controllers.payloads.StockPayload;
import execice.jpa.Exercice.Jpa.repo.production.stocks.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper {

    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);
    StockDTO toDTO(Stock stock);
    Stock toEntity(StockPayload payload);
}
