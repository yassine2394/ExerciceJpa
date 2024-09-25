package execice.jpa.Exercice.Jpa.controllers;


import execice.jpa.Exercice.Jpa.controllers.payloads.CategoryPayload;
import execice.jpa.Exercice.Jpa.controllers.payloads.ProductPayload;
import execice.jpa.Exercice.Jpa.controllers.payloads.StockPayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.CategoryDTO;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.ProductDTO;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.StockDTO;
import execice.jpa.Exercice.Jpa.services.ProductionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/production")
@AllArgsConstructor
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    //Gestion de categories
    @GetMapping("/category/create")
    public CategoryDTO createCategory(CategoryPayload payload){
        CategoryDTO categoryDTO = productionService.CreateCategory(payload);
        return  categoryDTO;
    }

    @GetMapping("/category/{id}")
    public CategoryDTO getCategoryById(@PathVariable int id){
        CategoryDTO categoryDTO = productionService.getCategoryById(id);
        return categoryDTO;
    }

    @GetMapping("/category/all")
    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> dto = productionService.getAllCategory();
        return dto;
    }

    @PutMapping("/category/update/{id}")
    public CategoryDTO updateCategory(@PathVariable int id, @RequestBody CategoryPayload payload){
        CategoryDTO dto = productionService.updateCategory(id, payload);
        return dto;
    }

    @DeleteMapping("/category/delete/{id}")
    public void deleteCategory(@PathVariable int id){
        productionService.deleteCategory(id);
    }

    // Gestion de product
    @PostMapping("/product/create")
    public ProductDTO createProduct(@RequestBody ProductPayload payload){
        ProductDTO productDTO = productionService.createProduct(payload);
        return  productDTO;
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable int id){
        ProductDTO dto = productionService.getProductById(id);
        return dto;

    }

    @GetMapping("/product/all")
    public List<ProductDTO> getAllProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String marque){
        List<ProductDTO> productDTOS = productionService.getAllProduct(category, marque);
        return productDTOS;
    }

    @PutMapping("/product/update/{id}")
    public ProductDTO updateProduct(@PathVariable int id, ProductDTO productDTO){
        ProductDTO dto = productionService.updateProduct(id, productDTO);
        return  dto;
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        productionService.deleteProduct(id);
    }

    //Gestion de stock

    @PostMapping("/stock/create")
    public ResponseEntity<StockDTO> createStock(@RequestBody StockPayload payload) {
        StockDTO createdStock = productionService.createStock(payload);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
    }

    @GetMapping("/stock/all")
    public List<StockDTO> getAllStock(){
        List<StockDTO> dtos = productionService.getAllStock();
        return  dtos;
    }

    @GetMapping("/stock/{storeId}/{productId}")
    public StockDTO getStockById(@PathVariable int storeId, @PathVariable int productId){
        StockDTO dto= productionService.getStockById(storeId, productId);
        return  dto;
    }

    @PutMapping("/stock/update/{storeId}/{productId}")
    public StockDTO updateStock(@PathVariable int storeId, @PathVariable int productId, @RequestBody StockPayload payload){
        StockDTO dto = productionService.updateStock(storeId, productId, payload);
        return  dto;
    }

    @DeleteMapping("/stock/{storeId}/{productId}")
    public void deleteStock(@PathVariable int storeId,  @PathVariable int productId){
        productionService.deleteStock(storeId, productId);
    }

}
