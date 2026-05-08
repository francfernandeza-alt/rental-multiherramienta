package com.multiherramienta.multiherramienta.DTO;

import java.util.List;

import lombok.Data;

@Data

public class UsuarioDTO {
    private String rutUsuarioDTO;
    private String nombreUsuarioDTO;
    private String apellidoPaternoDTO;
    private String emailUsuarioDTO;
    private String direccionUsuarioDTO;
    private List<Integer> numeroReservas;

}
