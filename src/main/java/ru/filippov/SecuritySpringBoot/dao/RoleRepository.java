package ru.filippov.SecuritySpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.filippov.SecuritySpringBoot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
