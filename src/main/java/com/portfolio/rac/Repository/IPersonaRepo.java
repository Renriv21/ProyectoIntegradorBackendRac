
package com.portfolio.rac.Repository;

import com.portfolio.rac.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona,Long> {
    
}
