package ar.com.estudiocs.dao;

import ar.com.estudiocs.entities.Profesionales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProfesionalesDao extends JpaRepository<Profesionales, Integer> {
    @Query("select c from Profesionales c where c.nombre like ?1")

    public List<Profesionales> findByNombre(String nombre);

    Page<Profesionales> findAll(Pageable pageable);
}
