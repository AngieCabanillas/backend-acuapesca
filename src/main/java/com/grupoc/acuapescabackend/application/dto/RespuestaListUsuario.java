package com.grupoc.acuapescabackend.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupoc.acuapescabackend.domain.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListUsuario extends Respuesta{

    @JsonProperty("dato")
    List<Usuario> data;
}
