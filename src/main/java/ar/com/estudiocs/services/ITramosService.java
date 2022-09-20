package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.Tramos;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ITramosService {

    List<Tramos> getAll();

    Page<Tramos> findAll(Pageable pageable);

    List<Tramos> findByDescripcion(String descripcion);

    Tramos get(Integer id);

    void save(Tramos entity);

    String delete(Tramos entity);
}
