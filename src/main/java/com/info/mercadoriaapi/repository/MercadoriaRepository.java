package com.info.mercadoriaapi.repository;

import com.info.mercadoriaapi.model.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoriaRepository extends JpaRepository<Mercadoria, String> {
}
