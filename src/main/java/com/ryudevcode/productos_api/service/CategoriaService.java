package com.ryudevcode.productos_api.service;

import com.ryudevcode.productos_api.dto.CategoriaRequest;
import com.ryudevcode.productos_api.dto.CategoriaResponse;
import com.ryudevcode.productos_api.model.Categoria;
import com.ryudevcode.productos_api.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    //Injectamos la dependencia
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }


    //Crear una categoria
    public CategoriaResponse crear(CategoriaRequest categoriaRequest){
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequest.getNombre());
        Categoria guardada = categoriaRepository.save(categoria);
        return convertirAResponse(guardada);
    }

    //Mostrar todas las categorías
    public List<CategoriaResponse> listar(){
        return categoriaRepository.findAll().stream().map(this::convertirAResponse).toList();
    }

    //Buscar una categoria por Id
    public CategoriaResponse buscarPorId(Long id){
        return categoriaRepository.findById(id).map(this::convertirAResponse).orElse(null);
    }

    public CategoriaResponse actualizar(Long id, CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        //Si lo que nos retorna la linea de arriba es null retorna null y ya
        if(categoria == null){
            return  null;
        }
        //Si hay datos insértalos en el objeto y guarda en la BD
        categoria.setNombre((categoriaRequest.getNombre()));

        Categoria actualizada = categoriaRepository.save(categoria);
        //Una vez guardado el método retornamos lo que se ha guardado
         return convertirAResponse(actualizada);
    }

    public boolean eliminar(Long id){
        //Comprobamos si no existe la categoria (si se ha equivocado de id)
        if (!categoriaRepository.existsById(id)) {
            return false;
        }
        //Eliminamos la categoria
        categoriaRepository.deleteById(id);
        return true;
    }

    //Convertimos los objetos Categoria que vienen de la BD a objetos DTO y los devolvemos
    private CategoriaResponse convertirAResponse(Categoria categoria){
        return new CategoriaResponse(categoria.getId(), categoria.getNombre());
    }

}
