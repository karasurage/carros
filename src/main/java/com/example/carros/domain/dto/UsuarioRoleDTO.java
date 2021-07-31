package com.example.carros.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioRoleDTO {
    String login;
    String email;
    String role;
}