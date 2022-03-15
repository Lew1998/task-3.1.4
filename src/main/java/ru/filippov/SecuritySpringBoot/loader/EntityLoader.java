package ru.filippov.SecuritySpringBoot.loader;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.filippov.SecuritySpringBoot.model.Role;
import ru.filippov.SecuritySpringBoot.model.User;
import ru.filippov.SecuritySpringBoot.service.RoleService;
import ru.filippov.SecuritySpringBoot.service.UserService;

import java.util.Set;

@Component
public class EntityLoader implements InitializingBean {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void afterPropertiesSet() throws Exception {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        roleService.add(adminRole);
        roleService.add(userRole);

        User[] users = new User[]{
                new User("Ivan"
                        , "Ivanov",
                        "89812930423"
                        , "Ivan@mail.ru"
                        , passwordEncoder.encode("paswordqwerty"),
                        Set.of(adminRole)),

                new User("Nikolay"
                        , "Nikolaev"
                        , "89812948375"
                            , "Nikl@mail.ru"
                        , passwordEncoder.encode("paswordqwerty")
                        , Set.of(userRole))
        };
        userService.add(users[0]);
        userService.add(users[1]);
    }
}