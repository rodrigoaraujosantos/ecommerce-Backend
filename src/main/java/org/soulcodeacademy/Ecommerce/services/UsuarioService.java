package org.soulcodeacademy.Ecommerce.services;


import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardCliente;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardEmpreendedores;
import org.soulcodeacademy.Ecommerce.domain.Usuario;
import org.soulcodeacademy.Ecommerce.domain.dto.PerfilDTO;
import org.soulcodeacademy.Ecommerce.domain.dto.PerfilSenhaDTO;
import org.soulcodeacademy.Ecommerce.repository.UsuarioRepository;
import org.soulcodeacademy.Ecommerce.security.UsuarioSecurityService;
import org.soulcodeacademy.Ecommerce.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UsuarioSecurityService usuarioService;


    @Autowired
    private PasswordEncoder encoder;

    public List<Usuario> listarTodos(){
       return this.usuarioRepository.mostrarUsuarios();
    }
    public Usuario getUsuario(Integer id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado!");
        } else {
            return usuario.get();
        }
    }

    public int atualizarPerfil(Integer id, PerfilDTO dto) {

        Usuario u = this.getUsuario(id);

        u.setNome(dto.getNome());
        u.setSobrenome(dto.getSobrenome());
        u.setEmail(dto.getEmail());
        u.setCpf(dto.getCpf());
        u.setTelefone(dto.getTelefone());
        u.setDataNascimento(dto.getDataNascimento());
        u.setFoto(dto.getFoto());

        int modify = this.usuarioRepository.updateUserPerfil(u.getNome(), u.getSobrenome(), u.getDataNascimento(),
                u.getTelefone(), u.getCpf(), u.getEmail(), u.getId());
        return modify;
    }

    public int atualizarSenhaPerfil(Integer id, PerfilSenhaDTO dto) {
        Usuario usuario = this.getUsuario(id);
        String senhaAtual = usuario.getSenha();
        if (encoder.matches(dto.getSenha(), senhaAtual)) {
            int modify = this.usuarioRepository.updateSenhaPerfil((encoder.encode(dto.getNovaSenha())), usuario.getId());
            return modify;
        }

        else {
            throw new RecursoNaoEncontradoError("Senha atual incorreta");

        }

    }
    public Usuario desativarUsuario(Integer id){
        Usuario user = this.getUsuario(id);
        user.setAtivado(false);
        this.usuarioRepository.save(user);
        return user;

    }
 public Usuario buscarPorEmail(String email){
        return this.usuarioRepository.findByEmail(email).orElseThrow(()->new RecursoNaoEncontradoError("usuario na encontrado"));
 }


 public Usuario ativarUsuario(Integer id){
     Usuario user = this.getUsuario(id);
     user.setAtivado(true);
     this.usuarioRepository.save(user);
        return user;
 }

   public List<DashboardCliente> clienteCadastradosPorMes(String ano){
        return this.usuarioRepository.clienteCadastradosPorMes(ano);
    }

    public List<DashboardEmpreendedores>empreendedorCadastradoPorMes(String ano){
        return this.usuarioRepository.EmpreendedorCadastradoPorMes(ano);
    }

}

