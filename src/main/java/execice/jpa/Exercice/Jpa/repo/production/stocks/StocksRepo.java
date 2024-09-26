package execice.jpa.Exercice.Jpa.repo.production.stocks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StocksRepo extends JpaRepository<Stock, Integer> {
    Stock findByProductIdAndStoreId(int productId, int storeId);
    List<Stock> findByProductId(int productId);
}