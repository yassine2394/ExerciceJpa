package execice.jpa.Exercice.Jpa;

import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import execice.jpa.Exercice.Jpa.repo.sales.customers.CustomersRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class StartRunner implements ApplicationRunner {

    @Autowired CustomersRepo customersRepo;


    @Override
    public void run(ApplicationArguments args) throws Exception {
            List<Customer> customers = customersRepo.findAll();
            if(!customers.isEmpty()){
                System.out.println(customers.size() + " customers found");
            }
    }
}
