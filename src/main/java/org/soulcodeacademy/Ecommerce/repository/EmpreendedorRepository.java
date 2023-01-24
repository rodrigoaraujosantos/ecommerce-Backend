package org.soulcodeacademy.Ecommerce.repository;

import org.soulcodeacademy.Ecommerce.domain.Empreendedor;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpreendedorRepository extends JpaRepository<Empreendedor, Integer> {


    @Query(value = "select COUNT(id) as QuantidadeEmpreendedor\n" +
            "from usuarios\n" +
            "WHERE dtype ='empreendedor'AND \n" +
            " year(data_abertura)= :ano", nativeQuery = true)
    DashboardTotalCadastrados EmpreendedorCadastrados(String ano);


}
