package com.ryudevcode.productos_api.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    //Creamos la relacion de 1:N con la tabla producto (mappedBy hace la relacion)
    @OneToMany(mappedBy="categoria", cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();

    //Constructor sin parámetros necesario para funcionar
    public Categoria(){

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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
