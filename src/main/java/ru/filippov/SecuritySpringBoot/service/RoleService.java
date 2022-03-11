package ru.filippov.SecuritySpringBoot.service;

import ru.filippov.SecuritySpringBoot.model.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);
    List<Role> getAllRole();
    Role findByName(String name);
}
