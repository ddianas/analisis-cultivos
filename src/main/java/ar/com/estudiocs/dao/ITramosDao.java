package ar.com.estudiocs.dao;

import ar.com.estudiocs.entities.Profesionales;
import ar.com.estudiocs.entities.Tramos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITramosDao extends JpaRepository<Tramos, Integer> {
    @Query("select c from Tramos c where c.descripcion like ?1")
    public List<Tramos> findByDescripcion(String descripcion);

    Page<Tramos> findAll(Pageable pageable);
}
