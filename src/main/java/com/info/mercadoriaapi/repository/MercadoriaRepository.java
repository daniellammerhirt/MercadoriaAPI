package com.info.mercadoriaapi.repository;

import com.info.mercadoriaapi.model.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MercadoriaRepository extends JpaRepository<Mercadoria, String> {
    @Query("select m from Mercadoria m where m.quantidade<m.estoqueMinimo")
    public List<Mercadoria> findQuantidadeLowerThanEstoqueMinimo();
}
