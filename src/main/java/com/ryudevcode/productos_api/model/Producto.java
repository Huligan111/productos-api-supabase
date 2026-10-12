package com.ryudevcode.productos_api.model;

import jakarta.persistence.*;

//https://www.youtube.com/watch?v=4b105KHtIrk

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;
    private Integer stock;


    //Creamos la relación de N:1 con la tabla categoria y la llave foránea es categoria_id que esta en producto
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    //Constructor sin parámetros necesario para funcionar
    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
