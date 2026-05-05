package com.multiherramienta.multiherramienta.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pago")

public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    @NotNull
    @Column(nullable = false)
    private Integer monto;

    @NotNull
    @Column (nullable = false)
    private LocalDateTime fechaPago;

    @NotBlank(message = "El estado del pago es obligatorio")
    @Size(min = 2, max = 50, message = "El estado de pago debe tener entre 2 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String estadoPago;

    @NotBlank(message = "El método del pago es obligatorio")
    @Size(min = 5 , max = 50, message = "El estado de pago debe tener entre 5 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String metodoPago;

    @OneToOne
    @JoinColumn(name = "numeroReserva", nullable = false)
    private Reserva reserva;

}
