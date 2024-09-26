package execice.jpa.Exercice.Jpa.services;

import execice.jpa.Exercice.Jpa.dto.ProductDTO;
import execice.jpa.Exercice.Jpa.dto.ProductMapper;
import execice.jpa.Exercice.Jpa.repo.production.brands.Brand;
import execice.jpa.Exercice.Jpa.repo.production.brands.BrandsRepo;
import execice.jpa.Exercice.Jpa.repo.production.categories.CategoriesRepo;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.production.products.ProductsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductsRepo productsRepo;
    private final BrandsRepo brandRepo;
    private final CategoriesRepo categoriesRepo;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        Brand brand = brandRepo.findById(productDTO.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        product.setBrand(brand);
        Category category = categoriesRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productMapper.productToProductDTO(productsRepo.save(product));
    }

    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        if (!productsRepo.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        Product product = productMapper.productDTOToProduct(productDTO);
        product.setProductId(id);
        Brand brand = brandRepo.findById(productDTO.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        product.setBrand(brand);
        Category category = categoriesRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productMapper.productToProductDTO(productsRepo.save(product));
    }

    public void deleteProductById(int id) {
        if (!productsRepo.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productsRepo.deleteById(id);
    }

    public ProductDTO findProductById(int id) {
        Optional<Product> productOptional = productsRepo.findById(id);
        return productOptional.map(productMapper::productToProductDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<ProductDTO> findAllProducts() {
        return productMapper.productsToProductDTOs(productsRepo.findAll());
    }
}
