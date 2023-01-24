package org.soulcodeacademy.Ecommerce.services;

import org.soulcodeacademy.Ecommerce.domain.Administrador;
import org.soulcodeacademy.Ecommerce.domain.Endereco;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.soulcodeacademy.Ecommerce.domain.dto.AdministradorDTO;
import org.soulcodeacademy.Ecommerce.repository.AdministradorRepository;
import org.soulcodeacademy.Ecommerce.security.UsuarioSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
   private UsuarioSecurityService usuarioService;

    @Autowired
    private PasswordEncoder encoder;


    public List<Administrador> listar() {
        return this.administradorRepository.findAll();
    }

    public Administrador getAdministrador(Integer id) {
        Optional<Administrador> administrador = this.administradorRepository.findById(id);
        if (administrador.isEmpty()) {
            throw new RuntimeException("Administrador não encontrado!");
        } else {
            return administrador.get();
        }

    }

    public Administrador salvar(AdministradorDTO dto) {

        Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());

        Administrador administrador =  new Administrador(dto.getNome(), dto.getSobrenome(), dto.getEmail(),
                dto.getCpf(), encoder.encode(dto.getSenha()),dto.getTelefone(), dto.getDataNascimento(),this.enderecoService.getEndereco(dto.idEndereco));
        administrador.setFoto(dto.getFoto());
        Administrador salvo = this.administradorRepository.save(administrador);
        this.usuarioService.loadUserByUsername(dto.getEmail());
        return salvo;

    }

    public Administrador atualizar(Integer id, AdministradorDTO dto){

        Administrador atualADM = this.getAdministrador(id);


        Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());


        atualADM.setNome(dto.getNome());
        atualADM.setSobrenome(dto.getSobrenome());
        atualADM.setEmail(atualADM.getEmail());
        atualADM.setCpf(atualADM.getCpf());
        atualADM.setSenha(dto.getSenha());
        atualADM.setTelefone(dto.getTelefone());
        atualADM.setDataNascimento(dto.getDataNascimento());
        atualADM.setEndereco(endereco);

        Administrador administradorAtualizado = this.administradorRepository.save(atualADM);
        return administradorAtualizado;
    }

    public void deletarAdmin(Integer id){
        Administrador administrador = this.getAdministrador(id);
        this.administradorRepository.delete(administrador);
    }

    public DashboardTotalCadastrados admsCadastrados(String ano){
       return this.administradorRepository.AdmCadastrados(ano);
    }

}

