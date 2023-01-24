package org.soulcodeacademy.Ecommerce.domain.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpreendedorDTO extends UsuarioDTO {

    @NotBlank(message = "Campo Ramo de Atividade é obrigatório")
    private String nomeNegocio;

   @NotBlank(message = "Campo Ramo de Atividade é obrigatório")
    private String ramo;

   @NotNull(message = "Campo endereço é obrigatorio")
   private Integer idEndereco;
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

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
}
