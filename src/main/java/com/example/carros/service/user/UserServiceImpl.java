package com.example.carros.service.user;

import com.example.carros.domain.dto.UserDTO;
import com.example.carros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(UserDTO::create).collect(Collectors.toList());
    }
}