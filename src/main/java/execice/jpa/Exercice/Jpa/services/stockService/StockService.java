package execice.jpa.Exercice.Jpa.services.stockService;

import execice.jpa.Exercice.Jpa.controllers.payloads.StockPayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.StockDTO;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.StockMapper;
import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.production.products.ProductsRepo;
import execice.jpa.Exercice.Jpa.repo.production.stocks.Stock;
import execice.jpa.Exercice.Jpa.repo.production.stocks.StocksRepo;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import execice.jpa.Exercice.Jpa.repo.sales.stores.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    private StocksRepo stocksRepo;
    @Autowired
    private StoreRepo storeRepo;
    @Autowired
    private ProductsRepo productsRepo;

    private final StockMapper stockMapper = StockMapper.INSTANCE;

    public StockDTO createStock(StockPayload payload) {

        Optional<Store> store = storeRepo.findById(payload.getStoreId());
        Optional<Product> product = productsRepo.findById(payload.getProductId());

        Stock stock = new Stock();
        //stock.setStoreId(payload.getStoreId());
        //stock.setProductId(payload.getProductId());
        stock.setQuantity(payload.getQuantity());
        stock = stocksRepo.save(stock);
        return stockMapper.toDTO(stock);
    }

    public List<StockDTO> getAllStock(){
        List<Stock> stocks = stocksRepo.findAll();
        return stocks.stream().map(stockMapper::toDTO).collect(Collectors.toList());
    }

    public StockDTO getStockById(int storeId, int productId ){
        Stock stock = stocksRepo.findByStoreIdAndProductId(storeId, productId);
        return stockMapper.toDTO(stock);
    }

    public StockDTO updateStock(int storeId, int productId, StockPayload payload){
        Stock stock = stocksRepo.findByStoreIdAndProductId(storeId, productId);

        stock.setQuantity(payload.getQuantity());
        stock = stocksRepo.save(stock);
        return stockMapper.toDTO(stock);
    }

    public void deleteStock(int storeId, int productId){
        Stock stock = stocksRepo.findByStoreIdAndProductId(storeId, productId);
        stocksRepo.delete(stock);
    }

}
