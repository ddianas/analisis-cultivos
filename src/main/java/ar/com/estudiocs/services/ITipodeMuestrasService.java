package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.TipoDeMuestras;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ITipodeMuestrasService {

    List<TipoDeMuestras> getAll();

    Page<TipoDeMuestras> findAll(Pageable pageable);

    List<TipoDeMuestras> findByDescripcion(String descripcion);

    TipoDeMuestras get(Integer id);

    void save(TipoDeMuestras entity);

    String delete(TipoDeMuestras entity);
}
