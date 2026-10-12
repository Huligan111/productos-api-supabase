package com.ryudevcode.productos_api.repository;

import com.ryudevcode.productos_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

//https://www.youtube.com/watch?v=4b105KHtIrk

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //Desde aquí accedemos a los métodos que trabajan con la base de datos con la herencia
}
