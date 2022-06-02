package com.code.basmaonlinestoreuserservices.controller;

import com.code.basmaonlinestoreuserservices.entity.User;
import com.code.basmaonlinestoreuserservices.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@RestController
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("get useers");
        System.out.println("test get users");
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
