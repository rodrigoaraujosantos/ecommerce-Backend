package org.soulcodeacademy.Ecommerce.security;

import org.soulcodeacademy.Ecommerce.domain.Usuario;
import org.soulcodeacademy.Ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioSecurityService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmail(username);
        Usuario usuario = usuarioOptional.orElseThrow(()-> new UsernameNotFoundException("Usuario Não encontrado"));

        return new UsuarioSecurity(usuario.getEmail(),usuario.getSenha(),usuario.getPerfil(),usuario.isAtivado());

    }
}
