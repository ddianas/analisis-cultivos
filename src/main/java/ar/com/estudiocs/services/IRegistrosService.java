package ar.com.estudiocs.services;

import ar.com.estudiocs.entities.RegistrosAnalisis;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface IRegistrosService {

    List<RegistrosAnalisis> getAll();

    Page<RegistrosAnalisis> findAll(Pageable pageable);

    List<RegistrosAnalisis> findByFecha(Date fecha);

    RegistrosAnalisis get(Integer id);

    void save(RegistrosAnalisis entity);

    String delete(RegistrosAnalisis entity);
}
