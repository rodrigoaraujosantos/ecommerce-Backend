package org.soulcodeacademy.Ecommerce.controller;

import org.soulcodeacademy.Ecommerce.domain.Categoria;
import org.soulcodeacademy.Ecommerce.domain.dto.CategoriaDTO;
import org.soulcodeacademy.Ecommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;



    @GetMapping("/produtos/gerais/categorias")
    public List<Categoria> listar(){
        return this.categoriaService.listar();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @GetMapping("/categorias/{idCategoria}")
    public Categoria getCategoria(@PathVariable Integer idCategoria){
        return this.categoriaService.getCategoria(idCategoria);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPREENDEDOR')")
    @PostMapping("/categorias")
    public Categoria salvarCategorias(@Valid @RequestBody CategoriaDTO dto){
       return this.categoriaService.salva(dto);

    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPREENDEDOR')")
    @PutMapping("/categorias/{idCategoria}")
    public Categoria atualizar(@PathVariable Integer idCategoria, @Valid @RequestBody CategoriaDTO dto){
        Categoria atualizado = this.categoriaService.atualizar(idCategoria, dto);
        return atualizado;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPREENDEDOR')")
    @DeleteMapping("/categorias/{idCategoria}")
    public void deletar(@PathVariable Integer idCategoria){
        this.categoriaService.deletar(idCategoria);
    }



}
