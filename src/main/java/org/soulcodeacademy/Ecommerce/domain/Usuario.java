package org.soulcodeacademy.Ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.soulcodeacademy.Ecommerce.domain.enums.Perfil;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

@Entity
@Table(name = "usuarios")
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false, length = 150)
    protected String nome;

    @Column(nullable = false, length = 150)
    protected String sobrenome;

    @Column(nullable = false, unique = true, length = 120)
    protected String email;

    @Column(nullable = false, unique = true, length = 11)
    protected String cpf;

    @JsonIgnore
    @Column(nullable = false)
    protected String senha;

    @Column(nullable = false)
    protected String telefone;


    @Column(nullable = false)
    protected String dataNascimento;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Perfil perfil;

    private boolean ativado = true;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private LocalDate dataAbertura = LocalDate.now();

    @Column(columnDefinition = "MEDIUMTEXT")
    private String foto;


    @Enumerated(EnumType.STRING)
    private Month mesDeCadastroUsuario = LocalDate.now().getMonth();

    public Usuario() {
    };


    public Usuario(String nome, String sobrenome, String email, String cpf, String senha, String telefone, String dataNascimento, Endereco endereco, Perfil perfil) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.perfil = perfil;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Month getMesDeCadastroUsuario() {
        return mesDeCadastroUsuario;
    }

    public void setMesDeCadastroUsuario(Month mesDeCadastroUsuario) {
        this.mesDeCadastroUsuario = mesDeCadastroUsuario;
    }
}
