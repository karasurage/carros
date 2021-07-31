package com.example.carros.api;

import com.example.carros.domain.User;
import com.example.carros.domain.dto.UserDTO;
import com.example.carros.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity get() {
        List<UserDTO> list = userService.getUsers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/info")
    public UserDTO userInfo(@AuthenticationPrincipal User user) {

        //UserDetails userDetails = JwtUtil.getUserDetails();

        return UserDTO.create(user);
    }
}