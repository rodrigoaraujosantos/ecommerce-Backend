package org.soulcodeacademy.Ecommerce.domain;

import javax.persistence.*;

@Entity
public class Fotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFoto;

    @Column(nullable = false)
    private String url;
    @ManyToOne
    @JoinColumn(name = "id_Produto")
    private Produto produto;

    public  Fotos(){}

    public Fotos(String url, Produto produto) {
        this.url = url;
        this.produto = produto;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
