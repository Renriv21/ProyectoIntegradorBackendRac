
package com.portfolio.rac.Interface;

import com.portfolio.rac.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una lista de Personas
       public List<Persona> getPersona();
    //guardar un objeto de tipo Persona
       public void savePersona(Persona persona);
    //Eliminar un objeto por id
       public void deletePersona(Long id);
    //Buscar persona por Id
       public Persona findPersona (Long id);
}
