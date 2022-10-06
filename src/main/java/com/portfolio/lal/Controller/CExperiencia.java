package com.portfolio.lal.Controller;

import com.portfolio.lal.Dto.dtoExperiencia;
import com.portfolio.lal.Entity.Experiencia;
import com.portfolio.lal.Security.Controller.Mensaje;
import com.portfolio.lal.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existsByNombreE(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa Experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        //Se pregunta si el ID existe
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara el Nombre de las experiencias
        if (sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //Asegura que el campo no este vacio
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        //Actualiza Experiencia
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Se pregunta si el ID existe
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sExperiencia.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    
}
