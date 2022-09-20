package ar.com.estudiocs.servicesimp;

import ar.com.estudiocs.dao.IUsuariosDao;
import ar.com.estudiocs.entities.Usuarios;
import ar.com.estudiocs.security.UserDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDetailsService")
public class UsuarioDetalleServiceImpl implements UserDetailsService {
    @Autowired
    private IUsuariosDao dao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final Usuarios retrievedUser = dao.findOneByUsername(userName);

        if (retrievedUser == null) {
            throw new UsernameNotFoundException("Usuario o Password Inválido(s)");
        }

        if (retrievedUser.getInactivo()) {
            throw new UsernameNotFoundException("Usuario Inhabilitado");
        }

        return UserDetailsMapper.build(retrievedUser);
    }

}

