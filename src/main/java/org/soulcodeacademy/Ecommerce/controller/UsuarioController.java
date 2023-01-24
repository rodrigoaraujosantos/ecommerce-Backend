package org.soulcodeacademy.Ecommerce.controller;



import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardCliente;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardEmpreendedores;
import org.soulcodeacademy.Ecommerce.domain.Usuario;
import org.soulcodeacademy.Ecommerce.domain.dto.PerfilDTO;
import org.soulcodeacademy.Ecommerce.domain.dto.PerfilSenhaDTO;
import org.soulcodeacademy.Ecommerce.repository.UsuarioRepository;
import org.soulcodeacademy.Ecommerce.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;



    @PreAuthorize("hasAnyRole('ROLE_CLIENTE', 'ROLE_EMPREENDEDOR', 'ROLE_ADMIN')")
    @GetMapping("/usuario/{id}")
    public Usuario getAdministrador(@PathVariable Integer id) {
        return this.usuarioService.getUsuario(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_CLIENTE', 'ROLE_EMPREENDEDOR', 'ROLE_ADMIN')")
    @PutMapping("/usuario/{id}")
    public int atualizarPerfil(@PathVariable Integer id, @Valid @RequestBody PerfilDTO dto){
        int modify = this.usuarioService.atualizarPerfil(id, dto);
        return modify;
    }

    @PreAuthorize("hasAnyRole('ROLE_CLIENTE', 'ROLE_EMPREENDEDOR', 'ROLE_ADMIN')")
    @PutMapping("/usuario/novaSenha/{id}")
    public int atualizarSenhaPerfil(@PathVariable Integer id, @Valid @RequestBody PerfilSenhaDTO dto){
        int modify = this.usuarioService.atualizarSenhaPerfil(id, dto);
        return modify;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/usuarios")
    public List<Usuario> listarTodos(){
        return this.usuarioService.listarTodos();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/user/{id}")
    public Usuario desativarUser(@PathVariable Integer id){
      return this.usuarioService.desativarUsuario(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_CLIENTE', 'ROLE_EMPREENDEDOR', 'ROLE_ADMIN')")
    @GetMapping("/usuario/email/{email}")
    public Usuario getUsuario(@PathVariable String email) {
       return this.usuarioService.buscarPorEmail(email);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/cadastrados/cliente")
    List<DashboardCliente>clienteCadastradosPorMes(@RequestParam String ano){
        return  this.usuarioService.clienteCadastradosPorMes(ano);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/empreendedor/cadastrado")
    List<DashboardEmpreendedores>empreendedorCadastradorPorMes(@RequestParam String ano){
        return this.usuarioService.empreendedorCadastradoPorMes(ano);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/user/ativar/{id}")
    public Usuario ativarUser(@PathVariable Integer id){
       return this.usuarioService.ativarUsuario(id);
    }

}
