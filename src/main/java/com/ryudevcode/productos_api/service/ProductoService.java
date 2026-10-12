package com.ryudevcode.productos_api.service;

import com.ryudevcode.productos_api.dto.ProductoRequest;
import com.ryudevcode.productos_api.dto.ProductoResponse;
import com.ryudevcode.productos_api.model.Categoria;
import com.ryudevcode.productos_api.model.Producto;
import com.ryudevcode.productos_api.repository.CategoriaRepository;
import com.ryudevcode.productos_api.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProductoResponse crear(ProductoRequest productoRequest) {
        Categoria categoria = categoriaRepository.findById(productoRequest.getCategoria_id()).orElse(null);

        //Comprobamos si nos ha devuelto una categoria desde la BD
        if (categoria == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setNombre(productoRequest.getNombre());
        producto.setPrecio((productoRequest.getPrecio()));
        producto.setStock(productoRequest.getStock());
        producto.setCategoria(categoria);

        Producto guardado = productoRepository.save(producto);
        return convertirAResponse(guardado);
    }

    //Devuelve todos los productos
    public List<ProductoResponse> listar() {
        return productoRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    public ProductoResponse buscarPorId(Long id) {
        return productoRepository.findById(id).map(this::convertirAResponse).orElse(null);
    }

    public ProductoResponse actualizar(Long id, ProductoRequest request) {
        Producto producto = productoRepository.findById(id).orElse(null);

        //Comprobamos si en la BD hay un producto con este ID
        if (producto == null) {
            return null;
        }

        Categoria categoria = categoriaRepository.findById(request.getCategoria_id()).orElse(null);
        //Comprobamos si en la BD hay una categoria con este ID
        if (categoria == null) {
            return null;
        }

        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setCategoria(categoria);

        Producto actualizado = productoRepository.save(producto);

        return convertirAResponse(actualizado);
    }

    //Eliminar un producto
    public boolean eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            return false;
        }
        productoRepository.deleteById(id);
        return true;
    }


    private ProductoResponse convertirAResponse(Producto producto) {
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getCategoria().getId(),
                producto.getCategoria().getNombre());
    }

}
