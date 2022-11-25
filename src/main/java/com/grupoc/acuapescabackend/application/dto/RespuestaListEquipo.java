package com.grupoc.acuapescabackend.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupoc.acuapescabackend.domain.entities.Equipo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListEquipo extends Respuesta {

    @JsonProperty("dato")
    List<Equipo> data;
}