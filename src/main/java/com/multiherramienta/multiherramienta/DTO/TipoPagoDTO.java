package com.multiherramienta.multiherramienta.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TipoPagoDTO {

    private Integer idPago;
    private Integer monto;
    private LocalDate fechaPago;
    private String estadoPago;
    private String metodoPago;
    private Integer numeroReserva;
}
