package com.example.carros.service.join;

import com.example.carros.domain.dto.UserDTO;
import com.example.carros.domain.dto.UsuarioRoleDTO;
import com.example.carros.repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinRepository joinRepository;

    @Override
    public List<UsuarioRoleDTO> findUsersAndRoles() {
        return joinRepository.findUsersAndRoles();
    }

    @Override
    public List<UserDTO> findUsersByRole(String role) {
        return joinRepository.findUsersByRole(role).stream().map(UserDTO::create).collect(Collectors.toList());
    }
}