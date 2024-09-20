package execice.jpa.Exercice.Jpa.repo.sales.staffs;

import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "staffs",schema = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Staff {
    @Id
    @Column(name = "staff_id")
    int staffId;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "phone")
    String phone;

    @Column(name = "active", nullable = false)
    byte active;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    Store store;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    Staff manager;

}
