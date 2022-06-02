package com.code.basmaonlinestoreuserservices;

import com.code.basmaonlinestoreuserservices.entity.Role;
import com.code.basmaonlinestoreuserservices.entity.User;
import com.code.basmaonlinestoreuserservices.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BasmaOnlineStoreUserServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasmaOnlineStoreUserServicesApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "USER", "view | check"));
            //userService.saveRole(new Role(null, "MANAGER"));
            Role role = userService.saveRole(new Role(null, "ADMIN", "manage crud things"));
            userService.saveRole(new Role(null, "SUPER_ADMIN", "manage every thongs"));
            Integer roleId= 6;
            Set<Role> roles = new HashSet<>();
            roles.add(role);


            userService.saveUser(new User(null, "aimad@test.com","aimadaimad", "aimad", "damia", true, roles ));

            *//*userService.saveUser(new User(null, "yassin EL", "yassin", "aimad@test.com", "aimadaimad", new ArrayList<>()));
            userService.saveUser(new User(null, "hajar EL", "hajar", "aimad@test.com", "aimadaimad", new ArrayList<>()));
            userService.saveUser(new User(null, "ziad EL", "ziad", "aimad@test.com", "aimadaimad", new ArrayList<>()));*//*




          *//*  userService.addRoleToUser("aimad", "Role_SUPER_ADMIN");
            userService.addRoleToUser("ziad", "Role_ADMIN");
            userService.addRoleToUser("hajar", "Role_USER");
            userService.addRoleToUser("yassin", "Role_ADMIN");*//*


        };


    }*/
}
