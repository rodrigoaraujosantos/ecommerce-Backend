package org.soulcodeacademy.Ecommerce.domain.Querys;

import org.soulcodeacademy.Ecommerce.domain.Endereco;
import org.soulcodeacademy.Ecommerce.domain.enums.Status;

import java.time.LocalDate;

public interface PedidoUsuario {
        String getEmailCliente();
        Integer getNumPedido();
        Status getPedidoStatus();
        LocalDate getDataCompra();
        Integer getEntrega();
        Double getTotal();
        String getFotoProd();
        String getNomeProd();
        String getProdDescr();
        String getRua();
        String getBairro();
        String getCidade();
        String getEstado();
        Integer getNumero();

//  endereco.numero as numero FROM operacao \n"

}
