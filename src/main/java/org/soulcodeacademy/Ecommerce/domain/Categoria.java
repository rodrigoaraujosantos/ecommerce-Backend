package org.soulcodeacademy.Ecommerce.domain;

import org.soulcodeacademy.Ecommerce.domain.enums.Tipo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo tipo não pode ser nulo")
    private Tipo departamento;


    @NotNull(message = "O campo categoria é obrigatório")
    private String nomeCategoria;




    public Categoria(){

    }

    public Categoria(Tipo departamento, String nomeCategoria) {

        this.departamento = departamento;
        this.nomeCategoria = nomeCategoria;

    }




    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Tipo getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Tipo departamento) {
        this.departamento = departamento;
    }



    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }


    }
