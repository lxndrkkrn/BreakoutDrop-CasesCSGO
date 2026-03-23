package org.example.breakoutdrop.Repositories;

import org.example.breakoutdrop.Entities.Role;
import org.example.breakoutdrop.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String roleName);
}
