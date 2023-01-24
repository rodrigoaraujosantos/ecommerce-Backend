package org.soulcodeacademy.Ecommerce.repository;

import org.soulcodeacademy.Ecommerce.domain.Cliente;


import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
public interface ClienteRepository  extends JpaRepository<Cliente,Integer> {

    @Query(value = "select COUNT(id) as quantidadeCliente\n" +
            "from usuarios\n" +
            "WHERE dtype = 'cliente'AND \n" +
            " year(data_abertura)= :ano", nativeQuery = true)
    DashboardTotalCadastrados clientesCadastrados(String ano);




}
