package execice.jpa.Exercice.Jpa.repo.production.stocks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StocksRepo extends JpaRepository<Stock, Integer> {

    Stock findByStoreIdAndProductId(int storeId, int productId);

}
