package com.grupoc.acuapescabackend.domain.repositories;

import com.grupoc.acuapescabackend.domain.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

}
