package com.example.carros.service.join;

import com.example.carros.domain.dto.UserDTO;
import com.example.carros.domain.dto.UsuarioRoleDTO;

import java.util.List;

public interface JoinService {

    List<UsuarioRoleDTO> findUsersAndRoles();

    List<UserDTO> findUsersByRole(String role);
}