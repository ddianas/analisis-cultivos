package ar.com.estudiocs.dao;


import ar.com.estudiocs.entities.Personal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPersonalDao extends JpaRepository<Personal, Integer> {
    @Query("select c from Personal c where c.nombre like ?1")

    public List<Personal> findByNombre(String nombre);

    Page<Personal> findAll(Pageable pageable);
}
