package org.soulcodeacademy.Ecommerce.repository;

import org.soulcodeacademy.Ecommerce.domain.Item;
import org.soulcodeacademy.Ecommerce.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

    @Query(value = "SELECT * FROM Item WHERE email = ?  AND carrinho = 'ABERTO'  ", nativeQuery = true)
    public List<Item> procurarPendencias(String email);

    @Query(value = "SELECT id_item,valor_parcial,carrinho,item.email,item.quantidade,id_pedido,item.produto FROM item\n" +
            "            INNER JOIN produto\n" +
            "            ON Item.produto = produto.id_produto\n" +
            "            INNER join usuarios ON produto.id_empresario = usuarios.id\n" +
            "            WHERE Item.carrinho in('PROCESSANDO', 'FECHADO') AND usuarios.nome_negocio  = ?;" , nativeQuery = true)
    public List<Item> ItensMinhaLoja(String nomeNegocio);
@Query(value = "SELECT item.id_item,item.valor_parcial,item.carrinho,item.email,item.quantidade,item.id_pedido,item.produto FROM item\n" +
        "INNER JOIN operacao\n" +
        "on item.id_pedido = operacao.id_pedido\n" +
        "INNER JOIN usuarios\n" +
        "on operacao.cliente = usuarios.id\n" +
        "where  operacao.id_pedido = ?;",nativeQuery = true)
    public List<Item>buscarItensDoPedido(Integer idPedido);


}
