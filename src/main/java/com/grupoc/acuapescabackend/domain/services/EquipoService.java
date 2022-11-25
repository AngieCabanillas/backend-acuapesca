package com.grupoc.acuapescabackend.domain.services;

import com.grupoc.acuapescabackend.domain.entities.Equipo;
import com.grupoc.acuapescabackend.domain.repositories.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo modificarEquipo(Equipo equipo){ return equipoRepository.save(equipo); }

    public void eliminarEquipo(Integer idEquipo) {
        equipoRepository.deleteById(idEquipo);
    }

    public List<Equipo> listarEquipo() { return equipoRepository.findAll(); }

    public Equipo obtenerEquipoPorIdEquipo(Integer idEquipo) {
        return equipoRepository.findById(idEquipo).orElse(new Equipo());
    }
}
