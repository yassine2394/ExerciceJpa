package execice.jpa.Exercice.Jpa.controllers.userController;


import execice.jpa.Exercice.Jpa.repo.authentification.user.Role;
import execice.jpa.Exercice.Jpa.repo.authentification.user.RoleRepo;
import execice.jpa.Exercice.Jpa.repo.authentification.user.User;
import execice.jpa.Exercice.Jpa.repo.authentification.user.UserRepo;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/assignRole")
    public ResponseEntity<?> assignRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
        return ResponseEntity.ok("Role assigned successfully");
    }


}


