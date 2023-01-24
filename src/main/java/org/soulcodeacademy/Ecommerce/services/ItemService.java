package org.soulcodeacademy.Ecommerce.services;


import org.soulcodeacademy.Ecommerce.domain.Item;
import org.soulcodeacademy.Ecommerce.domain.Pedido;
import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.soulcodeacademy.Ecommerce.domain.dto.ItemDTO;
import org.soulcodeacademy.Ecommerce.domain.dto.PedidoDTO;
import org.soulcodeacademy.Ecommerce.domain.enums.Carrinho;
import org.soulcodeacademy.Ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoService pedidoService;

    public Item getItem(Integer id){
        return this.itemRepository.findById(id).orElseThrow(()-> new RuntimeException("Item Não Encontrada"));

    }
    public List<Item> meusItens(String email){
        return this.itemRepository.procurarPendencias(email);
    }

    public Item novoItem(ItemDTO dto){

        Item novoitem = new Item(dto.getQuantidade(), dto.getEmail(), dto.getValorParcial() , dto.getProduto());
        Produto produto = this.produtoService.getProduto(dto.getProduto().getIdProduto());
        produto.setEstoque((produto.getEstoque()-dto.getQuantidade()));

        return this.itemRepository.save(novoitem);
    }
    public Item atualizarStatusDoItem(Integer idItem, Carrinho dto) {
        Item itemAtual = this.getItem(idItem);
        itemAtual.setCarrinho(dto);
        itemAtual.setPedidoVinculado(itemAtual.getPedidoVinculado());
        itemAtual.setValorParcial(itemAtual.getValorParcial());
        itemAtual.setQuantidade(itemAtual.getQuantidade());
        itemAtual.setEmail(itemAtual.getEmail());


        return this.itemRepository.save(itemAtual);

    }

    public Item AtualizarQTD(Integer id,ItemDTO dto){
        Item itemAtual = this.getItem(id);
        Produto produto = this.produtoService.getProduto(dto.getProduto().getIdProduto());
        Double valorUnit = dto.getProduto().getValor();
        itemAtual.setEmail(itemAtual.getEmail());
        itemAtual.setProduto(itemAtual.getProduto());
        itemAtual.setCarrinho(itemAtual.getCarrinho());
        itemAtual.setQuantidade(dto.getQuantidade());
        itemAtual.setValorParcial((valorUnit * dto.getQuantidade()));

        produto.setEstoque((produto.getEstoque()-dto.getQuantidade()));

        return  this.itemRepository.save(itemAtual);
    }

    public Item vincularAoPedido(Integer idPedido,Integer idItem){
        Pedido pedido = this.pedidoService.getPedido(idPedido);
        Item itemAtual = this.getItem(idItem);
        itemAtual.setPedidoVinculado(pedido);
        itemAtual.setCarrinho(Carrinho.PROCESSANDO);
        return itemRepository.save(itemAtual);

    }
    public List<Item> findByPedido(Integer idPedido){
        return this.itemRepository.buscarItensDoPedido(idPedido);
    }
    public void deletarItemDoCarrinho(Integer id){
        Item item = this.getItem(id);
        this.itemRepository.delete(item);
    }

    public List<Item>meusProdutosPendentes(String nomeNegocio){
        return this.itemRepository.ItensMinhaLoja(nomeNegocio);
    }

}