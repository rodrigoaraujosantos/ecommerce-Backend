package org.soulcodeacademy.Ecommerce.security;

import org.soulcodeacademy.Ecommerce.domain.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UsuarioSecurity implements UserDetails{

    private String email;

    private String senha;

    private Perfil perfil;

    private boolean ativado;

    private ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    public UsuarioSecurity(String email, String senha, Perfil perfil,boolean ativado){
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.authorities.add(new SimpleGrantedAuthority(perfil.getDescricao()));
        this.ativado = ativado;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.ativado;
    }
}
