package execice.jpa.Exercice.Jpa.repo.sales.stores;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Sort;

@Entity
@Table(name = "stores", schema = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Store {
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;
    @Column(name = "store_name")
    private String storeName;
    private String phone;
    private  String email;
    private String street;
    private String city;
    private String state;
    @Column(name = "zip_code", columnDefinition ="int")
    private int zipCode;
}
