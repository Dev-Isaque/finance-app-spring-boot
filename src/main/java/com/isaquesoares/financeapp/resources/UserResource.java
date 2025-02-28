package com.isaquesoares.financeapp.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.isaquesoares.financeapp.model.User;
import com.isaquesoares.financeapp.model.dto.UserDTO;
import com.isaquesoares.financeapp.model.dto.LoginResponseDTO;
import com.isaquesoares.financeapp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody UserDTO userDTO) {
        LoginResponseDTO response = service.login(userDTO.getEmail(), userDTO.getPassword());

        if ("Login realizado com sucesso!".equals(response.getMessage())) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(response); // Retorna código HTTP 401 (Não autorizado)
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody UserDTO userDTO) {
        Map<String, String> response = new HashMap<>();

        if (userDTO == null || userDTO.getEmail() == null || userDTO.getPassword() == null ||
                userDTO.getEmail().trim().isEmpty() || userDTO.getPassword().trim().isEmpty()) {
            response.put("message", "Erro: Email e senha são obrigatórios!");
            return ResponseEntity.badRequest().body(response);
        }

        boolean success = service.register(userDTO);

        response.put("message", success ? "Usuário cadastrado com sucesso!" : "Erro: Usuário já cadastrado!");
        return success ? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/me/id")
    public ResponseEntity<Map<String, Object>> getUserId(@RequestParam String email) {
        User user = service.findByEmail(email);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());

        return ResponseEntity.ok(response);
    }

}