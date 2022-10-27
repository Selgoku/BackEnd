package com.portfolio.lal.Repository;

import com.portfolio.lal.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer> {

    public Optional<Proyecto> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
