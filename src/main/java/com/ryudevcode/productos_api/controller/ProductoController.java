package com.ryudevcode.productos_api.controller;
//https://www.youtube.com/watch?v=4b105KHtIrk

import com.ryudevcode.productos_api.dto.ProductoRequest;
import com.ryudevcode.productos_api.dto.ProductoResponse;

import com.ryudevcode.productos_api.service.ProductoService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> crear(@RequestBody ProductoRequest productoRequest){
        ProductoResponse producto = productoService.crear(productoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> listar(){
        return ResponseEntity.ok(productoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> buscar(@PathVariable Long id){
        ProductoResponse producto = productoService.buscarPorId(id);

        if(producto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> actualizar(@PathVariable Long id, @RequestBody ProductoRequest request){
        ProductoResponse producto = productoService.actualizar(id, request);

        if(producto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoResponse> eliminar(@PathVariable Long id){
        boolean eliminado = productoService.eliminar(id);

        if(!eliminado){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
