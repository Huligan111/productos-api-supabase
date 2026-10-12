package com.ryudevcode.productos_api.dto;

//Con esta clase devolvemos los datos al Postman (asi podemos transformar o ocultar datos como el Id antes de devolverlos)

public class CategoriaResponse {

    private Long id;
    private String nombre;

    public CategoriaResponse() {

    }

    public CategoriaResponse(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
