package ar.com.estudiocs.dao;

import ar.com.estudiocs.entities.TipoDeMuestras;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipodeMuestrasDao extends JpaRepository<TipoDeMuestras, Integer> {
@Query("select c from TipoDeMuestras c where c.descripcion like ?1")
 public List<TipoDeMuestras> findByDescripcion(String descripcion);

Page<TipoDeMuestras> findAll(Pageable pageable);
}
