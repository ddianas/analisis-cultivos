package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.Categorias;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoriasService {
    List<Categorias> getAll();
    Page<Categorias> findAll(Pageable pageable);
    List<Categorias> findByDescripcion(String descripcion);
    Categorias get(Integer id);
    void save(Categorias entity);
    String delete(Categorias entity);
}
