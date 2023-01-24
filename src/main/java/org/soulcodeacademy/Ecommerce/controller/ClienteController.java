package org.soulcodeacademy.Ecommerce.controller;


import org.soulcodeacademy.Ecommerce.domain.Cliente;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.soulcodeacademy.Ecommerce.domain.dto.ClienteDTO;
import org.soulcodeacademy.Ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return this.clienteService.listar();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable Integer id){
        return this.clienteService.getCliente(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/clientes")
    public Cliente salvar(@Valid @RequestBody ClienteDTO dto){
        Cliente cliente = this.clienteService.salva(dto);
        return cliente;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE')")
    @PutMapping("/clientes/{id}")
    public Cliente atualizarCliente(@PathVariable Integer id, @Valid @RequestBody ClienteDTO dto){
        Cliente atualizado = this.clienteService.atualizar(id, dto);
        return atualizado;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/clientes/{id}")
    public void deletar(@PathVariable Integer id){
        this.clienteService.delete(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/clientes/total")
    DashboardTotalCadastrados totalClienteCadastrado(@RequestParam String ano){
        return this.clienteService.clientesCadastrados(ano);
    }

    }








