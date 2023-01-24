package org.soulcodeacademy.Ecommerce.services;


import org.soulcodeacademy.Ecommerce.domain.Endereco;
import org.soulcodeacademy.Ecommerce.domain.dto.EnderecoDTO;
import org.soulcodeacademy.Ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

        @Autowired
        private EnderecoRepository enderecoRepository;

        public List<Endereco> listar() {
            return this.enderecoRepository.findAll();
        }

        public Endereco getEndereco(Integer idEndereco) {
            Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);

            if(endereco.isEmpty()) {
                throw new RuntimeException("O endereço não foi encontrado!");
            } else {
                return endereco.get();
            }
        }

        public Endereco salvar(EnderecoDTO dto) {

            Endereco novoEndereco = new Endereco(dto.getCEP(), dto.getRua(), dto.getNumero(),dto.getBairro(), dto.getCidade(), dto.getEstado(), dto.getReferencia());
            return this.enderecoRepository.save(novoEndereco);
        }

    public Endereco atualizar (Integer idEndereco, EnderecoDTO dto) {
        Endereco enderecoAtual = this.getEndereco(idEndereco);
        enderecoAtual.setCEP(dto.getCEP());
        enderecoAtual.setRua(dto.getRua());
        enderecoAtual.setNumero(dto.getNumero());
        enderecoAtual.setBairro(dto.getBairro());
        enderecoAtual.setCidade(dto.getCidade());
        enderecoAtual.setEstado(dto.getEstado());
        enderecoAtual.setReferencia(dto.getReferencia());

        Endereco atualizado = this.enderecoRepository.save(enderecoAtual);
        return atualizado;
    }
        public void deletar(Integer idEndereco) {
            Endereco endereco = this.getEndereco(idEndereco);

            this.enderecoRepository.delete(endereco);
        }
}
