package ar.com.estudiocs.dao;

import ar.com.estudiocs.entities.Provincias;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProvinciasDao extends JpaRepository<Provincias, Integer> {
@Query("select c from Provincias c where c.descripcion like ?1")
public List<Provincias> findByDescripcion(String descripcion);

    Page<Provincias> findAll(Pageable pageable);
}
