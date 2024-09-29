package execice.jpa.Exercice.Jpa.repo.production.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepo extends JpaRepository<Product, Integer> {

    Product findByProductId(int id);

    List<Product> findByCategory_CategoryName(String categoryName);
    List<Product> findByBrand_BrandName(String brandName);
    List<Product> findByCategory_CategoryNameAndBrand_BrandName(String categoryName, String brandName);



}
