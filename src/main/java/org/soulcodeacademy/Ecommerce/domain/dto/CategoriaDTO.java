package org.soulcodeacademy.Ecommerce.domain.dto;

import org.soulcodeacademy.Ecommerce.domain.enums.Tipo;

import javax.validation.constraints.NotNull;

public class CategoriaDTO {

    @NotNull(message = "O tipo não pode ser nulo")
    private Tipo departamento;


    @NotNull(message = "O campo categoria não pode ser nulo ")
    private String nomeCategoria;

    public Tipo getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Tipo tipo) {
        this.departamento = tipo;
    }


    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String categoria) {
        this.nomeCategoria = categoria;
    }




}
