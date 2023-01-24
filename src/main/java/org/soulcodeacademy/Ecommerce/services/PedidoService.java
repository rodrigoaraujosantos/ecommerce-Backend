package org.soulcodeacademy.Ecommerce.services;

import org.soulcodeacademy.Ecommerce.domain.Pedido;
import org.soulcodeacademy.Ecommerce.domain.dto.PedidoDTO;
import org.soulcodeacademy.Ecommerce.repository.PedidoRepository;
import org.soulcodeacademy.Ecommerce.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;


    public List<Pedido>buscarMinhascompras(String email){
        return this.pedidoRepository.buscarMeusPedido(email);
    }
public List<Pedido>listarTodos(){
        return this.pedidoRepository.findAll();
}

    public Pedido getPedido(Integer id) {
        Optional<Pedido> pedido = this.pedidoRepository.findById(id);
        if (pedido.isEmpty()) {
            throw new RecursoNaoEncontradoError("Pedido não encontrado");
        } else {
            return pedido.get();
        }
    }

    public Pedido novoPedido(PedidoDTO dto){

        Pedido novoPedido = new Pedido(dto.getValorTotal(), dto.getCliente(), dto. getEntrega());

        return this.pedidoRepository.save(novoPedido);
    }

    public void deletar(Integer idPedido) {
        Pedido pedido = this.getPedido(idPedido);
        this.pedidoRepository.delete(pedido);
    }

    public Pedido atualizarStatus(Integer idPedido, PedidoDTO dto) {
        Pedido pedidoAtual = this.getPedido(idPedido);
        pedidoAtual.setStatus(dto.getStatus());
        pedidoAtual.setEntrega(pedidoAtual.getEntrega());


        return this.pedidoRepository.save(pedidoAtual);

    }
}