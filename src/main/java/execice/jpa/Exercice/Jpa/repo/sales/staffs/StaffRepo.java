package execice.jpa.Exercice.Jpa.repo.sales.staffs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

    Staff findByStaffId(int id);

    // Trouver tous les employés d'un manager donné
    Staff findByManager_StaffId(int managerId);

    // Trouver l'employé par son ID
    Optional<Staff> findById(int staffId);
}
