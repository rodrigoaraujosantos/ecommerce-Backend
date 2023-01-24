package org.soulcodeacademy.Ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.soulcodeacademy.Ecommerce.domain.enums.Carrinho;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idItem;


    protected Integer quantidade;

    protected String email;

    @Enumerated(EnumType.STRING)
    protected Carrinho carrinho = Carrinho.ABERTO;
    protected Double ValorParcial;

    @OneToOne
    @JoinColumn(name = "produto", nullable = false)
    protected Produto produto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pedido")
    private Pedido pedidoVinculado;

    public  Item(){}

    public Item(Integer quantidade, String email, Double valorParcial, Produto produto) {
        this.quantidade = quantidade;
        this.email = email;
        ValorParcial = valorParcial;
        this.produto = produto;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
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

    public Double getValorParcial() {
        return ValorParcial;
    }

    public void setValorParcial(Double valorParcial) {
        ValorParcial = valorParcial;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedidoVinculado() {
        return pedidoVinculado;
    }

    public void setPedidoVinculado(Pedido pedidoVinculado) {
        this.pedidoVinculado = pedidoVinculado;
    }
}
