package com.ryudevcode.productos_api.dto;

//Recibimos los datos que nos mandan desde Postman

public class CategoriaRequest {

    private String nombre;

    public CategoriaRequest(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
