package com.isaquesoares.financeapp.model.dto;

import com.isaquesoares.financeapp.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String cpf;
    private String dataNasc;
    private String sexo;
    private String telefone;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String email;
    private String password;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.dataNasc = user.getDataNasc();
        this.sexo = user.getSexo();
        this.telefone = user.getTelefone();
        this.cep = user.getCep();
        this.endereco = user.getEndereco();
        this.bairro = user.getBairro();
        this.cidade = user.getCidade();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}