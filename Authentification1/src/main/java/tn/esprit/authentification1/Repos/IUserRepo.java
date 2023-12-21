package tn.esprit.authentification1.Repos;

import tn.esprit.authentification1.Entity.Role;
import tn.esprit.authentification1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    User findByRole(Role role);

}
