package org.soulcodeacademy.Ecommerce.services;

import org.soulcodeacademy.Ecommerce.domain.Empreendedor;
import org.soulcodeacademy.Ecommerce.domain.Endereco;
import org.soulcodeacademy.Ecommerce.domain.Fotos;
import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.soulcodeacademy.Ecommerce.domain.dto.EmpreendedorDTO;
import org.soulcodeacademy.Ecommerce.repository.EmpreendedorRepository;
import org.soulcodeacademy.Ecommerce.repository.FotosRepository;
import org.soulcodeacademy.Ecommerce.repository.ProdutoRepository;
import org.soulcodeacademy.Ecommerce.security.UsuarioSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpreendedorService  {

    @Autowired
    private EmpreendedorRepository empreendedorRepository;

    @Autowired
    private EnderecoService endrecoservice;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FotosRepository fotosRepository;


    @Autowired
    private UsuarioSecurityService usuarioService;


    @Autowired
    private PasswordEncoder encoder;


    public List<Empreendedor> listar() { return this.empreendedorRepository.findAll(); }

    public Empreendedor getEmpreendedor(Integer idEmpreendedor) {
        return this.empreendedorRepository.findById(idEmpreendedor)
                .orElseThrow(() -> new RuntimeException("Empreendedor não encontrado"));

    }



    public Empreendedor salvar(EmpreendedorDTO dto) {

        Endereco endereco = this.endrecoservice.getEndereco(dto.getIdEndereco());


        Empreendedor empreendedor = new Empreendedor(dto.getNome(), dto.getSobrenome(), dto.getEmail(), dto.getCpf(), encoder.encode(dto.getSenha()), dto.getTelefone(), dto.getDataNascimento(), endereco, dto.getNomeNegocio(), dto.getRamo());
        empreendedor.setFoto(dto.getFoto());

        Empreendedor salvo = this.empreendedorRepository.save(empreendedor);
        this.usuarioService.loadUserByUsername(dto.getEmail());
        return salvo;
    }

    public Empreendedor atualizar(Integer idEmpreendedor, EmpreendedorDTO dto) {
        Empreendedor empreendedorAtual = this.getEmpreendedor(idEmpreendedor);
        Endereco endereco = this.endrecoservice.getEndereco(dto.getIdEndereco());

        empreendedorAtual.setNome(dto.getNome());
        empreendedorAtual.setSobrenome(dto.getSobrenome());
        empreendedorAtual.setEmail(empreendedorAtual.getEmail());
        empreendedorAtual.setCpf(empreendedorAtual.getCpf());
        empreendedorAtual.setSenha(encoder.encode(dto.getSenha()));
        empreendedorAtual.setTelefone(dto.getTelefone());
        empreendedorAtual.setDataNascimento(dto.getDataNascimento());
        empreendedorAtual.setNomeNegocio(dto.getNomeNegocio());
        empreendedorAtual.setRamo(dto.getRamo());
        empreendedorAtual.setEndereco(endereco);
        return this.empreendedorRepository.save(empreendedorAtual);
    }

    public void deletar(Integer idEmpreendedor) {
        Empreendedor empreendedor = this.getEmpreendedor(idEmpreendedor);
        List<Produto>produtosDoEmpresario = this.produtoRepository.findByEmpreendedor(empreendedor);

        for(Produto varredura : produtosDoEmpresario){
            List<Fotos>fotosDosProdutos = this.fotosRepository.findByProduto(varredura);
            for(Fotos foto: fotosDosProdutos){
                this.fotosRepository.delete(foto);

            }
            this.produtoRepository.delete(varredura);
        }
        this.empreendedorRepository.delete(empreendedor);
    }

    public DashboardTotalCadastrados empreendedorCadastrados(String ano){
        return this.empreendedorRepository.EmpreendedorCadastrados(ano);
    }

}