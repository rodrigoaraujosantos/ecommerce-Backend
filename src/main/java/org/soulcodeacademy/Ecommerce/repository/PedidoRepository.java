package org.soulcodeacademy.Ecommerce.repository;

import org.soulcodeacademy.Ecommerce.domain.Pedido;
import org.soulcodeacademy.Ecommerce.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

    public List<Pedido>findByStatus(Status status);

    Optional<Pedido> findById(Integer id);


    @Query(value = " SELECT * from operacao \n" +
            "            INNER JOIN usuarios\n" +
            "            ON operacao.cliente = usuarios.id\n" +
            "            where usuarios.email = ?;",nativeQuery = true)
    public List<Pedido> buscarMeusPedido(String email);




}
