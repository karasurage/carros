package com.example.carros.service.user;

import com.example.carros.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}