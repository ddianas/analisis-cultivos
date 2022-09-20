package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.Profesionales;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IProfesionalesService {

    List<Profesionales> getAll();

    Page<Profesionales> findAll(Pageable pageable);

    List<Profesionales> findByNombre(String nombre);

    Profesionales get(Integer id);

    void save(Profesionales entity);

    String delete(Profesionales entity);
}
