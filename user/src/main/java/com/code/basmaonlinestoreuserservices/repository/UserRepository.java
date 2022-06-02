package com.code.basmaonlinestoreuserservices.repository;

import com.code.basmaonlinestoreuserservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByEmail(String email);
    public Integer countById(Long id);
}
