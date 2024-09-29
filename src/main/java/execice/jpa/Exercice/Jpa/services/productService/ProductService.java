package execice.jpa.Exercice.Jpa.services.productService;

import execice.jpa.Exercice.Jpa.controllers.payloads.ProductPayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.ProductDTO;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.ProductMapper;
import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.production.products.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductsRepo productsRepo;
    private  final ProductMapper productMapper =ProductMapper.INSTANCE;

    public ProductDTO createProduct(ProductPayload payload){
        Product product = productMapper.toEntity(payload);
        product = productsRepo.save(product);
        return productMapper.toDTO(product);
    }

    public ProductDTO getProductById(int id){
        Product product = productsRepo.findByProductId(id);
        return  productMapper.toDTO(product);
    }

    public List<ProductDTO> getAllProduct(String categoryName, String brandName) {
        List<Product> products;

        if (categoryName != null && brandName != null) {
            products = productsRepo.findByCategory_CategoryNameAndBrand_BrandName(categoryName, brandName);
        } else if (categoryName != null) {
            products = productsRepo.findByCategory_CategoryName(categoryName);
        } else if (brandName != null) {
            products = productsRepo.findByBrand_BrandName(brandName);
        } else {
            products = productsRepo.findAll();
        }

        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public  ProductDTO updateProduct(int id , ProductDTO dto){
        Product product = productsRepo.findByProductId(id);

        product.setProductName(dto.getProductName());
        product.setModelYear(dto.getModelYear());
        product.setListPrice(dto.getListPrice());
        product.setBrand(product.getBrand());
        product.setCategory(product.getCategory());
        productsRepo.save(product);
        return productMapper.toDTO(product);
    }

    public void deleteProduct(int id){
        Product product = productsRepo.findByProductId(id);
        productsRepo.delete(product);
    }




}
