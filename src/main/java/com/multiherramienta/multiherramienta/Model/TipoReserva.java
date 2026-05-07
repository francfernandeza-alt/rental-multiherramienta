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
@Table(name = "Reserva")

public class TipoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroReserva;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaFin;

    @NotBlank(message = "El estado de la reserva es obligatorio")
    @Column(nullable = false, length = 50)
    private String estadoReserva;

    @OneToOne
    @JoinColumn(name = "rutUsuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "idHerramienta")
    private Herramienta herramienta;
}
