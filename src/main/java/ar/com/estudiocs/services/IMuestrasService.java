package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.Muestras;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IMuestrasService {
    List<Muestras> getAll();

    Page<Muestras> findAll(Pageable pageable);

    List<Muestras> findByConceptoIngreso(String conceptoIngreso);

    Muestras get(Integer id);

    void save(Muestras entity);

    String delete(Muestras entity);
}
