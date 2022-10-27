package com.portfolio.lal.Service;

import com.portfolio.lal.Entity.Proyecto;
import com.portfolio.lal.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    @Autowired RProyecto Rproyecto;
     public List<Proyecto> list() {
        return Rproyecto.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return Rproyecto.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombre) {
        return Rproyecto.findByNombre(nombre);
    }

    public void save(Proyecto proyecto) {
        Rproyecto.save(proyecto);
    }

    public void delete(int id) {
        Rproyecto.deleteById(id);
    }

    public boolean existsById(int id) {
        return Rproyecto.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return Rproyecto.existsByNombre(nombre);
    }
    
}