package execice.jpa.Exercice.Jpa.repo.production.brands;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "brands", schema = "production")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brand {
    @Id
    @Column(name = "brand_id")
    int brandId;

    @Column(name = "brand_name", nullable = false)
    String brandName;
}
