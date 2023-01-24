package org.soulcodeacademy.Ecommerce.domain.dto;

import javax.validation.constraints.NotBlank;

public class PerfilSenhaDTO {
    @NotBlank(message = "Senha atual obrigatório")
    protected String senha;

    @NotBlank(message = "Nova senha obrigatório")
    protected String novaSenha;


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
