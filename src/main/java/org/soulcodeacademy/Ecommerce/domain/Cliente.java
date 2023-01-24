package org.soulcodeacademy.Ecommerce.domain;

import org.soulcodeacademy.Ecommerce.domain.enums.Perfil;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario {

    public Cliente() {

    }


    public Cliente(String nome, String sobrenome, String email, String cpf, String senha, String telefone, String dataNascimento,  Endereco endereco) {

        super( nome, sobrenome, email, cpf, senha, telefone, dataNascimento, endereco, Perfil.CLIENTE);

    }

}
