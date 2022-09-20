package ar.com.estudiocs.dao;

import ar.com.estudiocs.entities.Muestras;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMuestrasDao  extends JpaRepository<Muestras, Integer> {
    @Query("select c from Muestras c where c.conceptoIngreso like ?1")
    public List<Muestras> findByConceptoIngreso(String conceptoIngreso);

    Page<Muestras> findAll(Pageable pageable);
}
