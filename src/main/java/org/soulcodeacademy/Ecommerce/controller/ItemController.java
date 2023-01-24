package org.soulcodeacademy.Ecommerce.controller;

import org.soulcodeacademy.Ecommerce.domain.Item;
import org.soulcodeacademy.Ecommerce.domain.Pedido;
import org.soulcodeacademy.Ecommerce.domain.dto.ItemDTO;
import org.soulcodeacademy.Ecommerce.domain.enums.Carrinho;
import org.soulcodeacademy.Ecommerce.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @GetMapping("/Item/{email}")
    public List<Item> listarItensDoCarrinho(@PathVariable String email){
        return  this.itemService.meusItens(email);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @PostMapping("/novoItem")
    public Item novoITem(@RequestBody ItemDTO dto){
        return this.itemService.novoItem(dto);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @PutMapping("/atualizarItem/{id}")
    public Item AtualizarQTD(@PathVariable Integer id ,@RequestBody ItemDTO dto ){
        return  this.itemService.AtualizarQTD(id,dto);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @PutMapping("/atualizarStatus/{id}")
    public Item AtualizarStatus(@PathVariable Integer id ,@RequestParam Carrinho status ){
        return  this.itemService.atualizarStatusDoItem(id,status);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @DeleteMapping("/deletarItem/{id}")
    public void ExcluirItem(@PathVariable Integer id){
        this.itemService.deletarItemDoCarrinho(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @PutMapping("/vincular/{idPedido}/{idItem}")
    public Item vincularItem(@PathVariable Integer idPedido,@PathVariable Integer idItem){
        return this.itemService.vincularAoPedido(idPedido,idItem);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @GetMapping("/Itens/{nomeNegocio}")
    public List<Item>  listarItensPendentesDaMinhaLoja(@PathVariable String nomeNegocio){
        return this.itemService.meusProdutosPendentes(nomeNegocio);
    }
    @GetMapping("/Itens/Pedido/{idPedido}")
    public List<Item>listarItensDoPedido(@PathVariable Integer idPedido){
        return this.itemService.findByPedido(idPedido);
    }

}