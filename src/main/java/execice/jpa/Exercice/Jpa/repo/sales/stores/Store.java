package execice.jpa.Exercice.Jpa.repo.sales.stores;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "Phone number must not be empty")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number must be valid")
    private String phone;

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email should be valid")
    private  String email;

    @NotBlank(message = "Street must not be empty")
    private String street;

    @NotBlank(message = "City must not be empty")
    private String city;

    @NotBlank(message = "State must not be empty")
    private String state;

    @NotNull(message = "Zip code must not be null")
    @Column(name = "zip_code", columnDefinition ="int")
    private int zipCode;
}
