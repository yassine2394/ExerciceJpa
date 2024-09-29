package execice.jpa.Exercice.Jpa.controllers.productController;

import execice.jpa.Exercice.Jpa.controllers.payloads.ProductPayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.ProductDTO;
import execice.jpa.Exercice.Jpa.services.productService.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    // Gestion de product
    @PostMapping("/create")
    public ProductDTO createProduct(@Valid @RequestBody ProductPayload payload){
        ProductDTO productDTO = productService.createProduct(payload);
        return  productDTO;
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id){
        ProductDTO dto = productService.getProductById(id);
        return dto;

    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String marque){
        List<ProductDTO> productDTOS = productService.getAllProduct(category, marque);
        return productDTOS;
    }


    @PutMapping("/{id}")
    public ProductDTO updateProduct(@Valid @PathVariable int id, ProductDTO productDTO){
        ProductDTO dto = productService.updateProduct(id, productDTO);
        return  dto;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

}
