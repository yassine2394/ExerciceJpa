package execice.jpa.Exercice.Jpa.controllers.stockController;

import execice.jpa.Exercice.Jpa.controllers.payloads.StockPayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.StockDTO;
import execice.jpa.Exercice.Jpa.services.stockService.StockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/stock")
@AllArgsConstructor
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/create")
    public ResponseEntity<StockDTO> createStock(@Valid @RequestBody StockPayload payload) {
        StockDTO createdStock = stockService.createStock(payload);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<StockDTO> getAllStock(){
        List<StockDTO> dtos = stockService.getAllStock();
        return  dtos;
    }

    @GetMapping("/{storeId}/{productId}")
    public StockDTO getStockById(@PathVariable int storeId, @PathVariable int productId){
        StockDTO dto= stockService.getStockById(storeId, productId);
        return  dto;
    }

    @PutMapping("/{storeId}/{productId}")
    public StockDTO updateStock(@Valid @PathVariable int storeId, @PathVariable int productId, @RequestBody StockPayload payload){
        StockDTO dto = stockService.updateStock(storeId, productId, payload);
        return  dto;
    }

    @DeleteMapping("/{storeId}/{productId}")
    public void deleteStock(@PathVariable int storeId,  @PathVariable int productId){
        stockService.deleteStock(storeId, productId);
    }


}
