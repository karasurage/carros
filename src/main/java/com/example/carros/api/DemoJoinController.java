package com.example.carros.api;

import com.example.carros.domain.dto.UserDTO;
import com.example.carros.domain.dto.UsuarioRoleDTO;
import com.example.carros.service.join.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/join")
public class DemoJoinController {
    @Autowired
    private JoinService joinService;

    @GetMapping()
    public ResponseEntity get() {
        List<UsuarioRoleDTO> list = joinService.findUsersAndRoles();
        return list.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(list);
    }

    @GetMapping("/{role}")
    public ResponseEntity findUsersByRole(@PathVariable("role") String role) {
        List<UserDTO> list = joinService.findUsersByRole(role);
        return list.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(list);
    }
}