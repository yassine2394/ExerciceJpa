package execice.jpa.Exercice.Jpa.repo.sales.stores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StoreRepo extends JpaRepository<Store, Integer> {
    Store findByStoreId(int id);
}
