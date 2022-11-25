package com.grupoc.acuapescabackend.application.controllers;

import com.grupoc.acuapescabackend.application.dto.Respuesta;
import com.grupoc.acuapescabackend.application.dto.RespuestaEquipo;
import com.grupoc.acuapescabackend.application.dto.RespuestaListEquipo;
import com.grupoc.acuapescabackend.domain.entities.Equipo;
import com.grupoc.acuapescabackend.domain.services.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipo")

public class EquipoController {


    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping
    public ResponseEntity<RespuestaEquipo> crearEquipo(@Valid @RequestBody Equipo equipo) {

        RespuestaEquipo respuesta = new RespuestaEquipo();

        try {
            Equipo equipoNew = equipoService.crearEquipo(equipo);

            respuesta.setMensaje("Equipo creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(equipoNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    public ResponseEntity<RespuestaEquipo> modificarEquipo(@Valid @RequestBody Equipo equipo) {

        RespuestaEquipo respuesta = new RespuestaEquipo();

        try {
            Equipo equipoUpdate = equipoService.modificarEquipo(equipo);

            respuesta.setMensaje("Equipo modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(equipoUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{idEquipo}")
    public ResponseEntity<Respuesta> eliminarEquipo(@PathVariable("idEquipo") Integer idEquipo) {


        Respuesta respuesta = new Respuesta();

        try {

            equipoService.eliminarEquipo(idEquipo);

            respuesta.setMensaje("Equipo eliminado con éxito");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<RespuestaListEquipo> listarEquipo() {

        RespuestaListEquipo respuesta = new RespuestaListEquipo();

        try {
            List<Equipo> equipos = equipoService.listarEquipo();

            respuesta.setMensaje("Listado de equipos exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(equipos);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{idEquipo}")
    public ResponseEntity<RespuestaEquipo> obtenerEquipoPorIdEquipo(@PathVariable("idEquipo") Integer idEquipo)     {

        RespuestaEquipo respuesta = new RespuestaEquipo();

        try {
            Equipo equipo = equipoService.obtenerEquipoPorIdEquipo(idEquipo);

            respuesta.setMensaje("Equipo encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(equipo);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
}