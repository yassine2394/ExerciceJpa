package execice.jpa.Exercice.Jpa.repo.production.categories;

import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Category, Integer> {

}
