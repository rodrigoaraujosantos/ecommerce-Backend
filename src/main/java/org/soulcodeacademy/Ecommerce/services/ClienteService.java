package org.soulcodeacademy.Ecommerce.services;

import org.soulcodeacademy.Ecommerce.domain.Cliente;
import org.soulcodeacademy.Ecommerce.domain.Endereco;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.soulcodeacademy.Ecommerce.domain.dto.ClienteDTO;
import org.soulcodeacademy.Ecommerce.repository.ClienteRepository;
import org.soulcodeacademy.Ecommerce.security.UsuarioSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioSecurityService usuarioService;




    public List<Cliente> listar(){
        return this.clienteRepository.findAll();
    }

    public Cliente getCliente(Integer id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado!");
        } else {
            return cliente.get();
        }

    }

    public Cliente salva(ClienteDTO dto){
        Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());
        Cliente cliente = new Cliente(dto.getNome(), dto.getSobrenome(),dto.getEmail(), dto.getCpf(), encoder.encode(dto.getSenha()), dto.getTelefone(), dto.getDataNascimento(),this.enderecoService.getEndereco(dto.idEndereco));
        cliente.setFoto(dto.getFoto());
        Cliente salvo = this.clienteRepository.save(cliente);

        this.usuarioService.loadUserByUsername(dto.getEmail());
        return salvo;

    }

    public Cliente atualizar(Integer id, ClienteDTO dto){

        Cliente clienteAtual = this.getCliente(id);


        Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());


        clienteAtual.setNome(dto.getNome());
        clienteAtual.setSobrenome(dto.getSobrenome());
        clienteAtual.setEmail(clienteAtual.getEmail());
        clienteAtual.setCpf(clienteAtual.getCpf());
        clienteAtual.setSenha(encoder.encode(dto.getSenha()));
        clienteAtual.setTelefone(dto.getTelefone());
        clienteAtual.setDataNascimento(dto.getDataNascimento());
        clienteAtual.setEndereco(endereco);

        Cliente clienteAtualizado = this.clienteRepository.save(clienteAtual);
        return clienteAtual;
    }
    public void delete(Integer id){
        Cliente cliente =  this.getCliente(id);
        this.clienteRepository.delete(cliente);
    }

    public DashboardTotalCadastrados clientesCadastrados(String ano){
        return this.clienteRepository.clientesCadastrados(ano);
    }

}



