package org.soulcodeacademy.Ecommerce.domain.dto;

import org.soulcodeacademy.Ecommerce.domain.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ProdutoDTO {

    @NotNull(message = "Nome do produto não pode ser nulo")
    private String nome;
    @NotNull(message = "Valor não pode ser nulo")
    private Double Valor;
    private Double desconto;

    private Date validadeDesconto;

    @NotNull(message = "Estoque não pode ser nulo")
    private Integer estoque;

    @NotNull(message = "Categoria não pode ser nulo")
    private Categoria categoria;

    private String foto;
    @NotBlank
    private String descricao;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @NotNull
    private Integer idEmpreendedor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Date getValidadeDesconto() {
        return validadeDesconto;
    }

    public void setValidadeDesconto(Date validadeDesconto) {
        this.validadeDesconto = validadeDesconto;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }



    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getIdEmpreendedor() {
        return idEmpreendedor;
    }

    public void setIdEmpreendedor(Integer idEmpreendedor) {
        this.idEmpreendedor = idEmpreendedor;
    }
}
