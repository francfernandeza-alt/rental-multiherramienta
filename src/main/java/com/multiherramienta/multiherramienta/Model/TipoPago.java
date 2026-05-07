package com.multiherramienta.multiherramienta.Model;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TipoPago")
public class TipoPago {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    @NotNull(message = "El monto es obligatorio")
    @Column(nullable = false)
    private Integer monto;

    @NotNull(message = "La fecha de pago es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaPago;

    @NotBlank(message = "El estado del pago es obligatorio")
    @Column(nullable = false, length = 50)
    private String estadoPago;

    @NotBlank(message = "El método de pago es obligatorio")
    @Column(nullable = false, length = 50)
    private String metodoPago;

    @OneToOne
    @JoinColumn(name = "numeroReserva")
    private Reserva reserva;
}
