package com.code.basmaonlinestoreuserservices.repository;

import com.code.basmaonlinestoreuserservices.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
