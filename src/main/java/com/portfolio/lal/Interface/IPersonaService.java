package com.portfolio.lal.Interface;

import com.portfolio.lal.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer Lista
    public List<Persona> getPersona();
    
    //Guardar Tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar Usuario por Id
    public void deletePersona(Long id);
    
    //Buscar Persona por Id
    public Persona findPersona(Long id);
}
