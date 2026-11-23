package com.info.mercadoriaapi.service;


import com.info.mercadoriaapi.dto.MovimentacaoRequest;
import com.info.mercadoriaapi.dto.MovimentacaoResponse;
import com.info.mercadoriaapi.model.Mercadoria;
import com.info.mercadoriaapi.repository.MercadoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadoriaService {
    @Autowired
    private MercadoriaRepository mercadoriaRepository;

    public Mercadoria findById(String codBarras){
        Optional<Mercadoria> mercadoria = mercadoriaRepository.findById(codBarras);
        return mercadoria.orElse(null);
    }

    public List<Mercadoria> findAll(){
        return mercadoriaRepository.findAll();
    }

    public List<Mercadoria> findQuantidadeLowerThanEstoqueMinimo(){
        return mercadoriaRepository.findQuantidadeLowerThanEstoqueMinimo();
    }

    public Mercadoria save(Mercadoria mercadoria){
        return mercadoriaRepository.save(mercadoria);
    }

    public void delete(String codBarras){
        mercadoriaRepository.deleteById(codBarras);
    }

    public MovimentacaoResponse entry(String codBarras, Double movimentacao){
        Mercadoria mercadoria=findById(codBarras);
        mercadoria.setQuantidade(mercadoria.getQuantidade() + movimentacao);
        mercadoriaRepository.save(mercadoria);
        return new MovimentacaoResponse(true, "Entrada concluída!", mercadoria);
    }

    public MovimentacaoResponse exit(String codBarras, Double movimentacao){
        Mercadoria mercadoria = findById(codBarras);
        if (mercadoria.getQuantidade() >= movimentacao){
            mercadoria.setQuantidade(mercadoria.getQuantidade() - movimentacao);
            mercadoriaRepository.save(mercadoria);
            return new MovimentacaoResponse(true, "Retirada concluída!", mercadoria);
        }else {
            return new MovimentacaoResponse(false, "Não é possível retirar mais do que há!", mercadoria);
        }
    }
}
