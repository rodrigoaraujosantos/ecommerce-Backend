package org.soulcodeacademy.Ecommerce.repository;

import org.soulcodeacademy.Ecommerce.domain.Empreendedor;
import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardProdutos;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

 @Query(value = " SELECT * from produto\n" +
         " where super_produto = 1; ",nativeQuery = true)
    List<Produto> BuscarporSuperProduto ();

    List<Produto> findByEmpreendedor(Empreendedor empreendedor);

    @Query(value = "SELECT * FROM produto where estoque > 0 ;",nativeQuery = true)
    List<Produto>buscarPorQtd();

    @Query(value = "SELECT * FROM produto\n" +
            "INNER JOIN categoria \n" +
            "on produto.id_categoria = categoria.id_categoria\n" +
            " where categoria.nome_categoria = :categoria",nativeQuery = true)
    List<Produto>procurarPorCategoria(String categoria);
    List<Produto>findByValor(Double valor);

    List<Produto>findByNomeContaining(String nome);

    @Query(value = "SELECT * FROM produto WHERE desconto > 0", nativeQuery = true)
    List<Produto> findByProdutoComDesconto();


    @Query(value = "SELECT mes_de_cadastro As mes, COUNT(month(data_de_cadastro)) as cadastrados\n" +
            "            FROM produto\n" +
            "            WHERE year(data_de_cadastro) = '2023'\n" +
            "            GROUP BY month(data_de_cadastro) ORDER BY cadastrados desc;", nativeQuery = true)
    List<DashboardProdutos>produtosCadastradosPorMes(String ano);

  @Query(value ="SELECT week(data_de_cadastro) As semana, COUNT(id_produto) As quantidade\n" +
          "          FROM produto\n" +
          "          WHERE  year(data_de_cadastro)='2023'\n" +
          "          GROUP BY week(data_de_cadastro)ORDER BY semana asc", nativeQuery = true)
    List<DashboardProdutos>ProdutosCadastradosPorSemana(String ano);

    @Query(value = "select COUNT(id_produto) As QuantidadeProdutos\n" +
            "from produto\n" +
            "WHERE \n" +
            " year(data_de_cadastro)=:ano", nativeQuery = true)
    DashboardTotalCadastrados ProdutosCadastrados(String ano);

    @Query(value = "select sum(item.quantidade) as qtdVendido,  produto.nome as nomeProduto,\n" +
            "categoria.nome_categoria as categoria\n" +
            " from produto\n" +
            " join item\n" +
            " on item.produto = produto.id_produto \n" +
            " join categoria\n" +
            " on produto.id_categoria = categoria.id_categoria\n" +
            " join operacao \n" +
            " on operacao.id_pedido = item.id_pedido\n" +
            " where operacao.status='RECEBIDO' and  operacao.data_da_compra  like concat(?, '%%' , '%%')\n" +
            " group by categoria.nome_categoria order by item.quantidade asc",nativeQuery = true)
    List<DashboardProdutos>ProdutosmaisVendidosMes(String ano);

    @Query(value = "SELECT data_da_compra as mes ,COUNT(*) as quantidade FROM operacao\n" +
            " where operacao.data_da_compra  like concat(?, '%%', '%%')\n" +
            " GROUP BY month(data_da_compra)",nativeQuery = true)
     List<DashboardProdutos>TotalProdutosVendidosMes(String ano);

}
