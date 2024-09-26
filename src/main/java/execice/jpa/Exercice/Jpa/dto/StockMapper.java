package execice.jpa.Exercice.Jpa.dto;

import execice.jpa.Exercice.Jpa.repo.production.stocks.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    StockDTO stockToStockDTO(Stock stock);
    Stock stockDTOToStock(StockDTO stockDTO);
    List<StockDTO> stocksToStockDTOs(List<Stock> stocks);
}