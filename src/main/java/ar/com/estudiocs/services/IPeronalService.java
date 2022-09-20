package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.Personal;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IPeronalService {
    List<Personal> getAll();

    Page<Personal> findAll(Pageable pageable);

    List<Personal> findByNombre(String nombre);

    Personal get(Integer id);

    void save(Personal entity);

    String delete(Personal entity);
}
