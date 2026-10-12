package com.ryudevcode.productos_api.repository;

import com.ryudevcode.productos_api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
