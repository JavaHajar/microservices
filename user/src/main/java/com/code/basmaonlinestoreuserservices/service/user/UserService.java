package com.code.basmaonlinestoreuserservices.service.user;

import com.code.basmaonlinestoreuserservices.entity.Role;
import com.code.basmaonlinestoreuserservices.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    /*void addRoleToUser(String username, String roleName);*/
    User getUser(String username);
    List<User> getUsers();
}
