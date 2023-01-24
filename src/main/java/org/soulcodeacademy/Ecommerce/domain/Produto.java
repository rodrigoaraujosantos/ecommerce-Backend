package org.soulcodeacademy.Ecommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    @NotNull(message = "Este campo não pode ser nulo")
    private String nome;
    @NotNull(message = "Este campo não pode ser nulo")
    private Double valor;


    private Double desconto;

    private Date validadeDesconto;

    @NotNull(message = "Este campo não pode ser nulo")
    private Integer estoque;

    @NotNull(message = "categoria não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
    @Column(columnDefinition = "VARCHAR(255)")
    private String foto;
    @NotNull
    @Column(columnDefinition = "MEDIUMTEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_empresario", nullable = false)
    private Empreendedor empreendedor;

    private LocalDate dataDeCadastro = LocalDate.now();



    private String nomeNegocio ;
    public Produto() {}


    @Enumerated(EnumType.STRING)
    private Month mesDeCadastro = LocalDate.now().getMonth();


    private boolean superProduto = false;



    public Produto(String nome, String descricao,Double valor, Date validadeDesconto, Double desconto, Integer estoque,Categoria categoria, String foto,Empreendedor empreendedor) {
        this.nome = nome;
        this.valor = valor;
        this.desconto = desconto;
        this.validadeDesconto = validadeDesconto;
        this.estoque = estoque;
        this.categoria = categoria;
        this.foto = foto;
        this.empreendedor = empreendedor;
        this.descricao = descricao;
        this.nomeNegocio = empreendedor.getNomeNegocio();
    }

    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Date getValidadeDesconto() {
        return validadeDesconto;
    }

    public void setValidadeDesconto(Date validadeDesconto) {
        this.validadeDesconto = validadeDesconto;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }


    public Month getMesDeCadastro() {
        return mesDeCadastro;
    }

    public void setMesDeCadastro(Month mesDeCadastro) {
        this.mesDeCadastro = mesDeCadastro;
    }


    public boolean isSuperProduto() {
        return superProduto;
    }

    public void setSuperProduto(boolean superProduto) {
        this.superProduto = superProduto;
    }


    public String getNomeNegocio() {
        return nomeNegocio;
    }
}




