package org.soulcodeacademy.Ecommerce.controller;

import org.soulcodeacademy.Ecommerce.domain.Endereco;
import org.soulcodeacademy.Ecommerce.domain.dto.EnderecoDTO;
import org.soulcodeacademy.Ecommerce.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class EnderecoController {

        @Autowired
        private EnderecoService enderecoService;

        @PreAuthorize("hasRole('ROLE_ADMIN')")
        @GetMapping("/enderecos")
        public List<Endereco> listar(){
            return this.enderecoService.listar();
        }

        @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE')")
        @GetMapping("/endereco/{idEndereco}")
        public Endereco getEndereco(@PathVariable Integer idEndereco) {
            return this.enderecoService.getEndereco(idEndereco);
        }

        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENTE')")
        @PostMapping("/endereco")
        public Endereco salvarEndereco(@Valid @RequestBody EnderecoDTO dto) {
            Endereco salvo = this.enderecoService.salvar(dto);
            return salvo;
        }

        @PreAuthorize("hasAnyRole('ROLE_CLIENTE', 'ROLE_EMPREENDEDOR', 'ROLE_ADMIN')")
        @PutMapping("/endereco/{idEndereco}")
        public Endereco atualizar(@PathVariable Integer idEndereco, @Valid @RequestBody EnderecoDTO dto) {
            Endereco endereco = this.enderecoService.atualizar(idEndereco , dto);
            return endereco;
        }

        @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE')")
        @DeleteMapping("/endereco/{idEnderecos}")
        public void deletar(@PathVariable Integer idEnderecos) {
            this.enderecoService.deletar(idEnderecos);
        }
}
