package com.isaquesoares.financeapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.isaquesoares.financeapp.model.User;
import com.isaquesoares.financeapp.model.dto.LoginResponseDTO;
import com.isaquesoares.financeapp.model.dto.UserDTO;
import com.isaquesoares.financeapp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean register(UserDTO userDTO) {
        if (userDTO == null || userDTO.getEmail() == null || userDTO.getPassword() == null ||
                userDTO.getEmail().trim().isEmpty() || userDTO.getPassword().trim().isEmpty()) {
            return false;
        }

        String emailLower = userDTO.getEmail().trim().toLowerCase();

        if (userRepository.findByEmail(emailLower).isPresent()) {
            return false; // Usuário já existe
        }

        User newUser = new User(
                null,
                userDTO.getName(),
                userDTO.getCpf(),
                userDTO.getDataNasc(),
                userDTO.getSexo(),
                userDTO.getTelefone(),
                userDTO.getCep(),
                userDTO.getEndereco(),
                userDTO.getBairro(),
                userDTO.getCidade(),
                emailLower,
                passwordEncoder.encode(userDTO.getPassword()) // Criptografa a senha
        );

        userRepository.save(newUser);
        return true;
    }

    public LoginResponseDTO login(String email, String password) {
        if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty()) {
            return new LoginResponseDTO("E-mail e senha são obrigatórios!", null);
        }

        String emailLower = email.trim().toLowerCase();
        Optional<User> userOptional = userRepository.findByEmail(emailLower);

        if (userOptional.isPresent() && passwordEncoder.matches(password, userOptional.get().getPassword())) {
            return new LoginResponseDTO("Login realizado com sucesso!", String.valueOf(userOptional.get().getId()));
        } else {
            return new LoginResponseDTO("E-mail ou senha inválidos!", null);
        }
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
