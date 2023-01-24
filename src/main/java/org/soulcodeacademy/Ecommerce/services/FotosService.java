package org.soulcodeacademy.Ecommerce.services;

import org.soulcodeacademy.Ecommerce.domain.Fotos;
import org.soulcodeacademy.Ecommerce.domain.Produto;
import org.soulcodeacademy.Ecommerce.domain.dto.FotoDTO;
import org.soulcodeacademy.Ecommerce.repository.FotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotosService {
        @Autowired
        private FotosRepository fotosRepository;

        @Autowired
        private ProdutoService produtoservice;


        public List<Fotos>findAll(){
            return this.fotosRepository.findAll();
        }
        public Fotos getFoto(Integer id){
            return this.fotosRepository.findById(id).orElseThrow(()-> new RuntimeException("Foto Não Encontrada"));
        }
        public Fotos salvar(FotoDTO dto){
            Produto produto = this.produtoservice.getProduto(dto.getIdProduto()) ;
            Fotos novaFoto = new Fotos(dto.getUrl(),produto );
            this.fotosRepository.save(novaFoto);
            return novaFoto;
        }
        public Fotos atualizar(Integer id ,FotoDTO dto){
            Fotos fotoAtual = this.getFoto(id);
            Produto produto = this.produtoservice.getProduto(dto.getIdProduto());
            fotoAtual.setUrl(dto.getUrl());
            fotoAtual.setProduto(produto);
            this.fotosRepository.save(fotoAtual);
            return fotoAtual;
        }
        public String deletar(Integer id){
            Fotos fotoAtual = this.getFoto(id);
            this.fotosRepository.delete(fotoAtual);
            return "Foto Apagada";
        }
        public List<Fotos> buscarPorProduto(Integer id){
            Produto produto = this.produtoservice.getProduto(id);
            return this.fotosRepository.findByProduto(produto);

        }
}
