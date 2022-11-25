package com.grupoc.acuapescabackend.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupoc.acuapescabackend.domain.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaUsuario extends Respuesta{

    @JsonProperty("dato")
    Usuario data;
}
