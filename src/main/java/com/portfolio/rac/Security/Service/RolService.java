
package com.portfolio.rac.Security.Service;

import com.portfolio.rac.Security.Entity.Rol;
import com.portfolio.rac.Security.Enums.RolNombre;
import com.portfolio.rac.Security.Repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
     return rolRepository.findRolByRolNombre(rolNombre);
     
    }
    
    public void save(Rol rol){
    rolRepository.save(rol);
    }
}
