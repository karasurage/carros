package com.example.carros.domain;

import lombok.Data;

@Data
public class JwtLoginInput {
    private String username;
    private String password;
}