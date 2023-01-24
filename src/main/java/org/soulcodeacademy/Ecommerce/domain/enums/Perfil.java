package org.soulcodeacademy.Ecommerce.domain.enums;

public enum Perfil {
    ADMIN("ROLE_ADMIN"),

    EMPREENDEDOR("ROLE_EMPREENDEDOR"),

    CLIENTE("ROLE_CLIENTE")
    ;
    private String descricao;
    Perfil(String descricao) {this.descricao = descricao;}

    public String getDescricao() {return descricao;}
}
