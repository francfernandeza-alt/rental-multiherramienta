package com.multiherramienta.multiherramienta.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TipoReserva")
public class TipoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoReserva;

    @NotBlank(message = "El nombre del tipo de reserva es obligatorio")
    @Column(nullable = false, length = 50)
    private String nombreTipoReserva;
}
