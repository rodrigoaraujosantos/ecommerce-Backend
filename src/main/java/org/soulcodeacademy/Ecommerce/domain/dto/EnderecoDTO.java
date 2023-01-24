package org.soulcodeacademy.Ecommerce.domain.dto;

import javax.validation.constraints.NotNull;

public class EnderecoDTO {
    @NotNull(message = "Este campo não pode ser nulo")
    private String CEP;
    @NotNull(message = "Este campo não pode ser nulo")
    private String rua;

    @NotNull(message = "Este campo não pode ser nulo")
    private Integer numero;

    @NotNull(message = "Este campo não pode ser nulo")
    private String bairro;

    @NotNull(message = "Este campo não pode ser nulo")
    private String cidade;

    @NotNull(message = "Este campo não pode ser nulo")
    private String estado;

    private  String referencia;

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }


}
