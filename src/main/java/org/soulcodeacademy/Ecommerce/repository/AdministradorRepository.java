package org.soulcodeacademy.Ecommerce.repository;


import org.soulcodeacademy.Ecommerce.domain.Administrador;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    @Query(value = "select COUNT(id) as QuantidadeAdm\n" +
            "from usuarios\n" +
            "WHERE dtype = 'administrador'AND \n" +
            " year(data_abertura)= :ano", nativeQuery = true)
    DashboardTotalCadastrados AdmCadastrados(String ano);

}