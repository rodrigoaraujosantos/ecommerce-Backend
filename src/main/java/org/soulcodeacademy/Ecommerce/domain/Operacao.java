package org.soulcodeacademy.Ecommerce.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public abstract class  Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idPedido;
    @Column(name = "valorTotal", columnDefinition = "Decimal(10,2) default '0.00'")
    protected Double valorTotal;
    @OneToOne
    @JoinColumn(name = "Cliente", nullable = false)
    protected Usuario cliente;



    protected LocalDate dataDaCompra = LocalDate.now();
public Operacao(){}

    public Operacao(Double valorTotal, Cliente cliente) {
        this.valorTotal = valorTotal;
        this.cliente = cliente;

    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }





    public LocalDate getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(LocalDate dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }
}
