package execice.jpa.Exercice.Jpa.repo.authentification.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles", schema = "auth")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", columnDefinition = "int")
    private int id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


}
