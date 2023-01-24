package org.soulcodeacademy.Ecommerce.domain.dto;

import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.soulcodeacademy.Ecommerce.domain.enums.Carrinho;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemDTO {
    @NotBlank(message = "quantidade não pode ser nula")
    protected Integer quantidade;

    @NotBlank(message = "O email não pode ser nulo")
    protected String email;

    protected Carrinho carrinho = Carrinho.ABERTO;

    @NotBlank(message = "O produto não pode ser nulo")
    protected  Produto produto;

    @NotNull
    protected Double valorParcial;

    protected Integer idPedido;

    public Double getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(Double valorParcial) {
        this.valorParcial = valorParcial;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
}
