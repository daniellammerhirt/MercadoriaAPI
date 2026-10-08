package com.info.mercadoriaapi.service;


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

    public Mercadoria save(Mercadoria mercadoria){
        return mercadoriaRepository.save(mercadoria);
    }

    public void delete(String codBarras){
        mercadoriaRepository.deleteById(codBarras);
    }
}
