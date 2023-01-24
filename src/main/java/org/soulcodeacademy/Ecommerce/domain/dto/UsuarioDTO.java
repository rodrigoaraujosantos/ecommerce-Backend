package org.soulcodeacademy.Ecommerce.domain.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public abstract class UsuarioDTO {
    @NotBlank(message = "Nome é obrigatório")
    protected String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    protected String email;

    @CPF(message = "CPF é inválido")
    @NotBlank(message = "CPF é obrigatório")
    protected String cpf;

    @NotBlank(message = "Senha é obrigatória")
    protected String senha;


    protected String telefone;

    @NotBlank(message = "Sobrenome é obrigatório")
    protected String sobrenome;

    @NotBlank(message = "Data de nascimento é obrigatória")
    protected String dataNascimento;

    protected String foto;


    public String getNome() {
        return nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
