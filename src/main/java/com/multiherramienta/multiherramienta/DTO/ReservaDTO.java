package com.multiherramienta.multiherramienta.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ReservaDTO {
    private Integer numeroReservaDTO;
    private LocalDateTime fechaInicioDTO;
    private LocalDateTime fechaFinDTO;
    private  String estadoReservaDTO;
    private String rutUsuarioDTO;
    private String nombreCompletoUsuarioDTO;
    private List <String> nombreHerramientas;
}
