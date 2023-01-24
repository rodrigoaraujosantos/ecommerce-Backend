package org.soulcodeacademy.Ecommerce.domain;

import org.soulcodeacademy.Ecommerce.domain.enums.Status;

import javax.persistence.*;


@Entity
@Table(name = "Pedidos")
public class Pedido extends Operacao {


    @Enumerated(EnumType.STRING)
    protected Status status = Status.RECEBIDO;


    @ManyToOne
    @JoinColumn(name = "id_endereco")
    protected Endereco Entrega;

    public  Pedido(){}




    public Pedido(Double valorTotal, Cliente cliente, Endereco entrega) {
        super(valorTotal, cliente);
        Entrega = entrega;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Endereco getEntrega() {
        return Entrega;
    }

    public void setEntrega(Endereco entrega) {
        Entrega = entrega;
    }
}
