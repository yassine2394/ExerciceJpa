package execice.jpa.Exercice.Jpa.repo.sales.staffs;

import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "staffs", schema = "sales")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String phone;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Staff staff;


}
