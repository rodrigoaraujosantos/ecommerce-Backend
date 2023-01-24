package org.soulcodeacademy.Ecommerce.controller;

import org.soulcodeacademy.Ecommerce.domain.Cliente;
import org.soulcodeacademy.Ecommerce.domain.Empreendedor;
import org.soulcodeacademy.Ecommerce.domain.Endereco;
import org.soulcodeacademy.Ecommerce.domain.dto.ClienteDTO;
import org.soulcodeacademy.Ecommerce.domain.dto.EmpreendedorDTO;
import org.soulcodeacademy.Ecommerce.domain.dto.EnderecoDTO;
import org.soulcodeacademy.Ecommerce.services.ClienteService;
import org.soulcodeacademy.Ecommerce.services.EmpreendedorService;
import org.soulcodeacademy.Ecommerce.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class CadastroController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EmpreendedorService empreendedorService;

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("auth/newCliente")
    public Cliente salvar(@Valid @RequestBody ClienteDTO dto){
        Cliente cliente = this.clienteService.salva(dto);
        return cliente;
    }
    @PostMapping("auth/newEmpreendedor")
    public Empreendedor salvar(@Valid @RequestBody EmpreendedorDTO dto) {
        Empreendedor empreendedor = this.empreendedorService.salvar(dto);
        return empreendedor;
    }
    @PostMapping("auth/newEndereco")
    public Endereco salvar(@Valid @RequestBody EnderecoDTO dto) {
        Endereco endereco = this.enderecoService.salvar(dto);
        return endereco;
    }
}
