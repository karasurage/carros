package com.example.carros.repository;

import com.example.carros.domain.User;
import com.example.carros.domain.dto.UsuarioRoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT new com.example.carros.domain.dto.UsuarioRoleDTO(u.login,u.email,r.nome) FROM User u inner join u.roles r")
    List<UsuarioRoleDTO> findUsersAndRoles();

    @Query(value = "SELECT u FROM User u inner join u.roles r WHERE r.nome like %:role%")
    List<User> findUsersByRole(@Param("role") String role);
}