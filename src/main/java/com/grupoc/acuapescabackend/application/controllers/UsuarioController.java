package com.grupoc.acuapescabackend.application.controllers;

import com.grupoc.acuapescabackend.application.dto.Respuesta;
import com.grupoc.acuapescabackend.application.dto.RespuestaUsuario;
import com.grupoc.acuapescabackend.domain.entities.Usuario;
import com.grupoc.acuapescabackend.domain.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<RespuestaUsuario> crearUsuario(@Valid @RequestBody Usuario usuario) {

        RespuestaUsuario respuesta = new RespuestaUsuario();

        try {
            Usuario usuarioNew = usuarioService.crearUsuario(usuario);

            respuesta.setMensaje("Usuario creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(usuarioNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaUsuario> modificarUsuario(@Valid @RequestBody Usuario usuario) {

        RespuestaUsuario respuesta = new RespuestaUsuario();

        try {
            Usuario usuarioUpdate = usuarioService.modificarUsuario(usuario);

            respuesta.setMensaje("Usuario modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(usuarioUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Respuesta> eliminarUsuario(@PathVariable("idUsuario") Integer idUsuario) {

        Respuesta respuesta = new Respuesta();

        try {

            usuarioService.eliminarUsuario(idUsuario);

            respuesta.setMensaje("Usuario eliminado con éxito");
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
    public ResponseEntity<RespuestaListUsuario> listarUsuario() {

        RespuestaListUsuario respuesta = new RespuestaListUsuario();

        try {
            List<Usuario> usuarios = usuarioService.listarUsuario();

            respuesta.setMensaje("Listado de Usuarios exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(usuarios);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{idUsuario}")
    public ResponseEntity<RespuestaUsuario> obtenerUsuarioPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {

        RespuestaUsuario respuesta = new RespuestaUsuario();

        try {
            Usuario usuario = usuarioService.obtenerUsuarioPorIdUsuario(idUsuario);

            respuesta.setMensaje("Usuario encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(usuario);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
}
