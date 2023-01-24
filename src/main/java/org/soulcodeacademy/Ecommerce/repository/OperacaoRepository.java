package org.soulcodeacademy.Ecommerce.repository;

import org.soulcodeacademy.Ecommerce.domain.Operacao;
import org.soulcodeacademy.Ecommerce.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Integer> {


}
