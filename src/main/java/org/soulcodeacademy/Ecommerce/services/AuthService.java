package org.soulcodeacademy.Ecommerce.services;


import org.soulcodeacademy.Ecommerce.domain.dto.CredenciaisDTO;
import org.soulcodeacademy.Ecommerce.domain.dto.TokenDTO;
import org.soulcodeacademy.Ecommerce.security.TokenUtil;
import org.soulcodeacademy.Ecommerce.security.UsuarioSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioSecurityService service;

    @Autowired
    private TokenUtil tokenUtil;

    public TokenDTO login(CredenciaisDTO dto){
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getSenha()));
        UserDetails usuario = this.service.loadUserByUsername(dto.getEmail());
        String perfil = this.getPerfil(usuario.getAuthorities());
        String token = this.tokenUtil.gerarToken(dto.getEmail(), perfil);

        return new TokenDTO(token);

    }

    private String getPerfil(Collection<? extends GrantedAuthority> authorities) {
        String perfil = null;

        for (GrantedAuthority authority : authorities) {
            perfil = authority.getAuthority();
        }

        return perfil;
    }
}
