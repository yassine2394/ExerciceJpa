package execice.jpa.Exercice.Jpa.services;

import execice.jpa.Exercice.Jpa.dto.StockDTO;
import execice.jpa.Exercice.Jpa.dto.StockMapper;
import execice.jpa.Exercice.Jpa.repo.production.stocks.Stock;
import execice.jpa.Exercice.Jpa.repo.production.stocks.StocksRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StockService {

    private final StocksRepo stocksRepo;
    private final StockMapper stockMapper = StockMapper.INSTANCE;

    public StockDTO addOrUpdateStock(StockDTO stockDTO) {
        Stock stock = stockMapper.stockDTOToStock(stockDTO);
        return stockMapper.stockToStockDTO(stocksRepo.save(stock));
    }

    public StockDTO findStocksByProductIdAndStoreId(int productId, int storeId) {
        return stockMapper.stockToStockDTO(stocksRepo.findByProductIdAndStoreId(productId, storeId));
    }

    public List<StockDTO> findStocksByProductId(int productId) {
        List<Stock> stocks = stocksRepo.findByProductId(productId);
        return stockMapper.stocksToStockDTOs(stocks);
    }

    public List<StockDTO> findAllStocks() {
        List<Stock> stocks = stocksRepo.findAll(); // Fetch all stocks
        return stockMapper.stocksToStockDTOs(stocks); // Map to DTOs
    }

}