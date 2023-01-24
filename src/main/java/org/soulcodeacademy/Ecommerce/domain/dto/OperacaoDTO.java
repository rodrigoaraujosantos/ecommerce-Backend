package org.soulcodeacademy.Ecommerce.domain.dto;

import org.soulcodeacademy.Ecommerce.domain.Cliente;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public abstract class OperacaoDTO {

    @NotBlank(message = "O valor total é obrigatorio")
    protected Double valorTotal;

    @NotBlank(message = "O Cliente é obrigatorio")
    protected Cliente cliente;

    protected LocalDate dataDaCompra ;

    public LocalDate getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(LocalDate dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
