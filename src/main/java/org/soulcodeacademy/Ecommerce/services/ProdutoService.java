package org.soulcodeacademy.Ecommerce.services;



import org.soulcodeacademy.Ecommerce.domain.Empreendedor;
import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardCliente;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardProdutos;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.soulcodeacademy.Ecommerce.domain.dto.ProdutoDTO;
import org.soulcodeacademy.Ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EmpreendedorService empreendedorService;

    @Autowired
    private CategoriaService categoriaService;

    public List<Produto> listarPorQtd() {
        return this.produtoRepository.buscarPorQtd();
    }

    public List<Produto> listar() {
        return this.produtoRepository.findAll();
    }
     public List<Produto> listasuperproduto(){
        return this.produtoRepository.BuscarporSuperProduto();
     }
    public Produto getProduto(Integer idProduto) {
        Optional<Produto> produto = this.produtoRepository.findById(idProduto);

        if (produto.isEmpty()) {
            throw new RuntimeException("O produto não foi encontrado!");
        } else {
            return produto.get();
        }
    }

    public Produto salvar(ProdutoDTO dto) {
        Empreendedor empreendedorDoProduto = this.empreendedorService.getEmpreendedor(dto.getIdEmpreendedor());


        Produto newProduto = new Produto(dto.getNome(), dto.getDescricao(), dto.getValor(), dto.getValidadeDesconto(), dto.getDesconto(), dto.getEstoque(), dto.getCategoria(), dto.getFoto(), empreendedorDoProduto);
        return this.produtoRepository.save(newProduto);
    }

    public Produto atualizar(Integer idProduto, ProdutoDTO dto) {
        Produto produtoAtual = this.getProduto(idProduto);

        produtoAtual.setNome(dto.getNome());
        produtoAtual.setValor(dto.getValor());
        produtoAtual.setValidadeDesconto(dto.getValidadeDesconto());
        produtoAtual.setDesconto(dto.getDesconto());
        produtoAtual.setEstoque(dto.getEstoque());
        produtoAtual.setCategoria(dto.getCategoria());
        produtoAtual.setDescricao(dto.getDescricao());
        produtoAtual.setFoto(dto.getFoto());


        Produto atualizado = this.produtoRepository.save(produtoAtual);
        return atualizado;
    }

    public List<Produto> buscarPorCategoria(String categoria) {
        return this.produtoRepository.procurarPorCategoria(categoria);

    }
    public List<Produto>buscarSuperProduto(){
        return this.produtoRepository.BuscarporSuperProduto();
    }

    public void zerarEstoque(Integer idProduto) {
        Produto produto = this.getProduto(idProduto);
        produto.setEstoque(0);
        this.produtoRepository.save(produto);
    }

    public List<Produto> listarPorNome(String nome) {
        return this.produtoRepository.findByNomeContaining(nome);
    }

    public List<Produto> listarPorValor(Double valor) {
        return this.produtoRepository.findByValor(valor);
    }

    public List<Produto> listarPorDesconto() {
        return this.produtoRepository.findByProdutoComDesconto();
    }

    public List<Produto> listarporEmpreendedor(Integer id) {
        Empreendedor empreendedor = this.empreendedorService.getEmpreendedor(id);
        return this.produtoRepository.findByEmpreendedor(empreendedor);
    }
    public List<DashboardProdutos>ProdutosCadastradosPorMes(String ano){
        return this.produtoRepository.produtosCadastradosPorMes(ano);
    }

    public List<DashboardProdutos>ProdutosCadastradosPorSemana(String ano){
        return this.produtoRepository.ProdutosCadastradosPorSemana(ano);
    }
    public DashboardTotalCadastrados produtosCadastrados(String ano){
        return this.produtoRepository.ProdutosCadastrados(ano);
    }
    public List <DashboardProdutos> produtosMaisVendidos(String ano){
        return this.produtoRepository.ProdutosmaisVendidosMes(ano);
    }

    public List <DashboardProdutos> TotalVendidoMes(String ano){
        return this.produtoRepository.TotalProdutosVendidosMes(ano);
    }


}

