package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.Localidades;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ILocalidadesServices {
    List<Localidades> getAll();

    Page<Localidades> findAll(Pageable pageable);

    List<Localidades> findByDescrip(String descrip);

    Localidades get(Integer id);

    void save(Localidades entity);

    String delete(Localidades entity);
}
