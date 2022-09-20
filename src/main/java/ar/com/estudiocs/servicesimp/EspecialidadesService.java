package ar.com.estudiocs.servicesimp;


import ar.com.estudiocs.dao.IEspecialidadesDao;

import ar.com.estudiocs.entities.Especialidades;
import ar.com.estudiocs.services.IEspecialidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EspecialidadesService implements IEspecialidadesService {
    @Autowired
    private IEspecialidadesDao especialidadesDao;

    public List<Especialidades> getAll() {
        return especialidadesDao.findAll(Sort.by(Sort.Direction.ASC, "especialidad"));
    }

    public Page<Especialidades> findAll(Pageable pageable) {
        return especialidadesDao.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.ASC, "especialidad")));
    }

    public List<Especialidades> findByEspecialidad(String especialidad) {
        return especialidadesDao.findByEspecialidad("%" + especialidad + "%");
    }

    public Especialidades get(Integer id) {
        return especialidadesDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Especialidades entity) {
        especialidadesDao.save(entity);
    }

    @Transactional
    public String delete(Especialidades entity) {
        try {
            especialidadesDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
