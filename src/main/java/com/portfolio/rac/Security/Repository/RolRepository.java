
package com.portfolio.rac.Security.Repository;

import com.portfolio.rac.Security.Entity.Rol;
import com.portfolio.rac.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findRolByRolNombre(RolNombre rolNombre);
}
