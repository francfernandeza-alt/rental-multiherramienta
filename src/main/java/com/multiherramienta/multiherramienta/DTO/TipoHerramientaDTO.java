package com.multiherramienta.multiherramienta.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TipoHerramientaDTO {

    @JsonProperty("idTipoHerramienta")
    private Integer idTipoHerramientaDTO;

    @JsonProperty("nombreTipoHerramienta")
    private String nombreTipoHerramientaDTO;

    @JsonProperty("descripcionTipoHerramienta")
    private String descripcionTipoHerramientaDTO;
}