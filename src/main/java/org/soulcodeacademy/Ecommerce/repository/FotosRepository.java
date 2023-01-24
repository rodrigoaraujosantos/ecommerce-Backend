package org.soulcodeacademy.Ecommerce.repository;

import org.soulcodeacademy.Ecommerce.domain.Fotos;
import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotosRepository extends JpaRepository<Fotos,Integer> {
    List<Fotos> findByProduto(Produto produto);
}
