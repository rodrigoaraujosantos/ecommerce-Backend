package org.soulcodeacademy.Ecommerce.domain.dto;

import org.soulcodeacademy.Ecommerce.domain.Endereco;
import org.soulcodeacademy.Ecommerce.domain.Item;
import org.soulcodeacademy.Ecommerce.domain.enums.Status;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO extends OperacaoDTO  {



    protected Status status;

    @NotBlank(message = "o endereço não pode ser nulo ")
    protected Endereco Entrega;



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
