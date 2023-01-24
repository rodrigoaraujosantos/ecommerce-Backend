package org.soulcodeacademy.Ecommerce.domain;

import org.soulcodeacademy.Ecommerce.domain.enums.Perfil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "empreendedor")
public class Empreendedor extends Usuario {


    @Column( length = 150,unique = true)
    private String nomeNegocio;

    @Column( length = 150)
    private String ramo;





    public Empreendedor() {
    }




    public Empreendedor(String nome, String sobrenome, String email, String cpf, String senha, String telefone, String dataNascimento, Endereco endereco, String nomeNegocio, String ramo) {
        super(nome, sobrenome, email, cpf, senha, telefone, dataNascimento,endereco,Perfil.EMPREENDEDOR);
        this.nomeNegocio = nomeNegocio;

        this.ramo = ramo;
    }

    public String getNomeNegocio() {
        return nomeNegocio;
    }

    public void setNomeNegocio(String nomeNegocio) {
        this.nomeNegocio = nomeNegocio;
    }



    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
}

