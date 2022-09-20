package ar.com.estudiocs.servicesimp;

import ar.com.estudiocs.dao.ICategoriasDao;
import ar.com.estudiocs.entities.Categorias;
import ar.com.estudiocs.services.ICategoriasService;
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
public class CategoriasService implements ICategoriasService {


        @Autowired
        private ICategoriasDao categoriasDao;

        public List<Categorias> getAll() {
            return categoriasDao.findAll(Sort.by(Sort.Direction.ASC, "descripcion"));
        }

        public Page<Categorias> findAll(Pageable pageable) {
            return categoriasDao.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.ASC, "descripcion")));
        }

        public List<Categorias> findByDescripcion(String descripcion) {
            return categoriasDao.findByDescripcion("%" + descripcion + "%");
        }

        public Categorias get(Integer id) {
            return categoriasDao.findById(id).orElse(null);
        }

        @Transactional
        public void save(Categorias entity) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            categoriasDao.save(entity);
        }

        @Transactional
        public String delete(Categorias entity) {
            try {
                categoriasDao.delete(entity);
                return null;
            } catch (Exception e) {
                return e.getMessage().toString();
            }
        }
    }