package execice.jpa.Exercice.Jpa.services;

import execice.jpa.Exercice.Jpa.controllers.payloads.CategoryPayload;
import execice.jpa.Exercice.Jpa.controllers.payloads.ProductPayload;
import execice.jpa.Exercice.Jpa.controllers.payloads.StockPayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.*;
import execice.jpa.Exercice.Jpa.repo.production.categories.CategoriesRepo;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
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
public class ProductionService {

    @Autowired
    private CategoriesRepo categoriesRepo;
    @Autowired
    private ProductsRepo productsRepo;
    @Autowired
    private StocksRepo stocksRepo;
    @Autowired
    private StoreRepo storeRepo;

    private  final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    private  final ProductMapper productMapper =ProductMapper.INSTANCE;
    private final StockMapper stockMapper = StockMapper.INSTANCE;


    // Gestion de Category
    public CategoryDTO CreateCategory(CategoryPayload payload){
        Category category = categoryMapper.toEntity(payload);
        category = categoriesRepo.save(category);
        return categoryMapper.toDTO(category);
    }

    public CategoryDTO getCategoryById(int id){
        Category category = categoriesRepo.findByCategoryId(id);
        return categoryMapper.toDTO(category);
    }

    public List<CategoryDTO> getAllCategory(){
        List<Category> categories = categoriesRepo.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());


    }

    public CategoryDTO updateCategory(int id, CategoryPayload payload){
        Category category = categoriesRepo.findByCategoryId(id);

        category.setCategoryName(payload.getCategoryName());
        category = categoriesRepo.save(category);
        return categoryMapper.toDTO(category);
    }

    public void deleteCategory(int id){
        Category category = categoriesRepo.findByCategoryId(id);
        categoriesRepo.delete(category);
    }

    // Gestion de product
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
        product.setBrand(dto.getBrand());
        product.setCategory(dto.getCategory());
        productsRepo.save(product);
        return productMapper.toDTO(product);
    }

    public void deleteProduct(int id){
        Product product = productsRepo.findByProductId(id);
        productsRepo.delete(product);
    }


    //Gestion de stock
    public StockDTO createStock(StockPayload payload) {

        Optional<Store> store = storeRepo.findById(payload.getStoreId());
        Optional<Product> product = productsRepo.findById(payload.getProductId());

        Stock stock = new Stock();
        stock.setStoreId(payload.getStoreId());
        stock.setProductId(payload.getProductId());
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

        //stock.setStoreId(payload.getStoreId());
        //stock.setProductId(payload.getProductId()); -> je commente ici pour ne pas modifier les 2 clés etrangère
        stock.setQuantity(payload.getQuantity());
        stock = stocksRepo.save(stock);
        return stockMapper.toDTO(stock);
    }

    public void deleteStock(int storeId, int productId){
        Stock stock = stocksRepo.findByStoreIdAndProductId(storeId, productId);
        stocksRepo.delete(stock);
    }

}
