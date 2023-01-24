package org.soulcodeacademy.Ecommerce.services;



import org.soulcodeacademy.Ecommerce.domain.Categoria;
import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.soulcodeacademy.Ecommerce.domain.dto.CategoriaDTO;
import org.soulcodeacademy.Ecommerce.domain.enums.Tipo;
import org.soulcodeacademy.Ecommerce.repository.CategoriaRepository;
import org.soulcodeacademy.Ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriarepository;





    public List<Categoria> listar() {
        return this.categoriarepository.findAll();
    }

    public Categoria getCategoria(Integer id) {
        Optional<Categoria> categoria = this.categoriarepository.findById(id);
        if (categoria.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada!");
        } else {
            return categoria.get();
        }
    }

    public Categoria salva(CategoriaDTO dto) {

        Categoria categoriaNova = new Categoria(dto.getDepartamento(), dto.getNomeCategoria());
        this.categoriarepository.save(categoriaNova);
        return categoriaNova;
    }


    public Categoria atualizar(Integer idCategoria, CategoriaDTO dto) {
        Categoria categoriaAtual = this.getCategoria(idCategoria);
        categoriaAtual.setNomeCategoria(dto.getNomeCategoria());

            switch (dto.getDepartamento()) {
                case HARDWARE -> {
                    categoriaAtual.setDepartamento(Tipo.HARDWARE);
                    categoriaAtual.setNomeCategoria(categoriaAtual.getNomeCategoria());

                }
                case SOFTWARE -> {
                    categoriaAtual.setDepartamento(Tipo.SOFTWARE);
                    categoriaAtual.setNomeCategoria(categoriaAtual.getNomeCategoria());

                }
            }

                return this.categoriarepository.save(categoriaAtual);
            }



        public void deletar (Integer idCategoria){
            Categoria categoria = this.getCategoria(idCategoria);
            this.categoriarepository.delete(categoria);
        }
    }


