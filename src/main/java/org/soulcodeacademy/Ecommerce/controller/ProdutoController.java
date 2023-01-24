package org.soulcodeacademy.Ecommerce.controller;

import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardCliente;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardProdutos;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.soulcodeacademy.Ecommerce.domain.dto.ProdutoDTO;
import org.soulcodeacademy.Ecommerce.repository.ProdutoRepository;
import org.soulcodeacademy.Ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @GetMapping("/produtos")
    public List<Produto> listar(){
        return this.produtoService.listar();
    }


    @GetMapping("/produtos/gerais")
    public List<Produto> listarComEstoque(){
        return this.produtoService.listarPorQtd();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPREENDEDOR','ROLE_CLIENTE')")
    @GetMapping("/produto/{idProduto}")
    public Produto getProduto(@PathVariable Integer idProduto){
        return this.produtoService.getProduto(idProduto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @PostMapping("/produto")
    public Produto salvarProduto(@Valid @RequestBody ProdutoDTO dto){
        return this.produtoService.salvar(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPREENDEDOR')")
    @PutMapping("/produto/{idProduto}")
    public Produto atualizar(@PathVariable Integer idProduto, @Valid @RequestBody ProdutoDTO dto){
        Produto atualizado = this.produtoService.atualizar(idProduto, dto);
        return atualizado;
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @DeleteMapping("/zerar/{idProdutos}")
    public void zerarEstoque(@PathVariable Integer idProdutos){
        this.produtoService.zerarEstoque(idProdutos);
    }


    @GetMapping("/produtos/gerais/nome")
    public List<Produto> listarPorNome(@RequestParam String filtro){
        return this.produtoService.listarPorNome(filtro);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR', 'ROLE_CLIENTE')")
    @GetMapping("/produtos/gerais/valor")
    public List<Produto> listarPorValor(@RequestParam Double filter){
        return this.produtoService.listarPorValor(filter);
    }

    @GetMapping("/produtos/gerais/categoria")
    public List<Produto>listarPorCategoria( @RequestParam String filtro){
        return this.produtoService.buscarPorCategoria(filtro);
    }
    @GetMapping("/produtos/gerais/desconto")
    public List<Produto>listarDesconto(){
        return this.produtoService.listarPorDesconto();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @GetMapping("/produtos/empreendedor/{idEmpreendedor}")
    public List<Produto>listarEmpreendedor(@PathVariable Integer idEmpreendedor){
        return this.produtoService.listarporEmpreendedor(idEmpreendedor);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/cadastrados/produtos")
    List<DashboardProdutos>produtosCadastradosPorMes(@RequestParam String ano){
        return  this.produtoService.ProdutosCadastradosPorMes(ano);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @GetMapping("/cadastrados/semanas")
    public List<DashboardProdutos>produtosCadastradosPorSemana(@RequestParam String ano){
        return this.produtoService.ProdutosCadastradosPorSemana(ano);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @GetMapping("/produtos/total")
    DashboardTotalCadastrados totalDeProdutosCadastrado(@RequestParam String ano){
        return this.produtoService.produtosCadastrados(ano);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @GetMapping("/produtos/vendidos")
    public List <DashboardProdutos>produtosMaisVendidos(@RequestParam String ano){
        return this.produtoService.produtosMaisVendidos(ano);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPREENDEDOR')")
    @GetMapping("/produtos/vendidosmes")
    public List <DashboardProdutos> totalProdutosMaisVendidos(@RequestParam String ano){
        return this.produtoService.TotalVendidoMes(ano);
    }

    @GetMapping("/produtos/gerais/superproduto")
    public List<Produto>listarSuperProduto(){
        return this.produtoService.listasuperproduto();
    }


}

