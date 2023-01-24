package org.soulcodeacademy.Ecommerce.controller;


import org.soulcodeacademy.Ecommerce.domain.Empreendedor;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.soulcodeacademy.Ecommerce.domain.Usuario;
import org.soulcodeacademy.Ecommerce.domain.dto.EmpreendedorDTO;
import org.soulcodeacademy.Ecommerce.services.EmpreendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpreendedorController extends Usuario {

    @Autowired
    private EmpreendedorService empreendedorService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/empreendedor")
    public List<Empreendedor> listar() { return this.empreendedorService.listar(); }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/empreendedor/{idEmpreendedor}")
    public Empreendedor buscarPorId(@PathVariable Integer idEmpreendedor) {
        return this.empreendedorService.getEmpreendedor(idEmpreendedor);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/empreendedor")
    public Empreendedor salvar(@Valid @RequestBody EmpreendedorDTO dto) {
        Empreendedor empreendedor = this.empreendedorService.salvar(dto);
        return empreendedor;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @PutMapping("/empreendedor/{idEmpreendedor}")
    public Empreendedor atualizar(@PathVariable  Integer idEmpreendedor, @Valid @RequestBody EmpreendedorDTO dto) {
        Empreendedor atualizado = this.empreendedorService.atualizar(idEmpreendedor, dto);
        return atualizado;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/empreendedor/{idEmpreendedor}")
    public void deletar(@PathVariable Integer idEmpreendedor) { this.empreendedorService.deletar(idEmpreendedor); }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/empreendedor/total")
    DashboardTotalCadastrados totalDeEmpreendedoresCadastrado(@RequestParam String ano){
        return this.empreendedorService.empreendedorCadastrados(ano);
    }
}