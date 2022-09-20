package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.Provincias;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IProvinciasService {

    List<Provincias> getAll();

    Page<Provincias> findAll(Pageable pageable);

    List<Provincias> findByDescripcion(String descripcion);

    Provincias get(Integer id);

    void save(Provincias entity);

    String delete(Provincias entity);
}
