package com.grupoc.acuapescabackend.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupoc.acuapescabackend.domain.entities.Equipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaEquipo extends Respuesta {

    @JsonProperty("dato")
    Equipo data;
}
