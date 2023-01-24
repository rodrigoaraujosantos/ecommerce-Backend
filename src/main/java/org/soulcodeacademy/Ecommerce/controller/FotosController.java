package org.soulcodeacademy.Ecommerce.controller;

import org.soulcodeacademy.Ecommerce.domain.Fotos;
import org.soulcodeacademy.Ecommerce.domain.dto.FotoDTO;
import org.soulcodeacademy.Ecommerce.services.FotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FotosController {
    @Autowired
    private FotosService fotosService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @GetMapping("/fotos")
    public List<Fotos>listar(){
        return this.fotosService.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @GetMapping("/fotos/{id}")
    public Fotos buscarPorId(@PathVariable Integer id){
        return this.fotosService.getFoto(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @GetMapping("/fotos/produto/{id}")
    public List<Fotos> buscarFotosDoProduto(@PathVariable Integer id){
        return this.fotosService.buscarPorProduto(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @PostMapping("/fotos")
    public Fotos salvar(@Valid @RequestBody  FotoDTO dto){
        return  this.fotosService.salvar(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @PutMapping("/fotos/{id}")
    public Fotos atualizar(@PathVariable Integer id, @RequestBody FotoDTO dto){
        return  this.fotosService.atualizar(id,dto);

    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPREENDEDOR')")
    @DeleteMapping("/fotos/{id}")
    public String deletar(@PathVariable Integer id){
        return this.fotosService.deletar(id);
    }
}
