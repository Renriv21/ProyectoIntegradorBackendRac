package com.portfolio.rac.Service;

import com.portfolio.rac.Entity.Persona;
import com.portfolio.rac.Interface.IPersonaService;
import com.portfolio.rac.Repository.IPersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// voy a traer las cosas de IpersonaService
public class ImpPersonaService implements IPersonaService {
@Autowired IPersonaRepo ipersonaRepo;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepo.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
       ipersonaRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
       ipersonaRepo.findById(id); 
    }

    @Override
    public Persona findPersona(Long id) {
       Persona persona = ipersonaRepo.findById(id).orElse(null);
       return persona;
    }

}
