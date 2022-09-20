package ar.com.estudiocs.dao;

import ar.com.estudiocs.entities.Localidades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocalidadesDao extends JpaRepository<Localidades, Integer> {
    @Query("select c from Localidades c where c.descrip like ?1")

    public List<Localidades> findByDescrip(String descrip);

    Page<Localidades> findAll(Pageable pageable);
}
