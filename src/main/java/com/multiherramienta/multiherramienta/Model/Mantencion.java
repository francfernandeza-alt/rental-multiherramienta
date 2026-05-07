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
@Table(name = "Mantencion")

public class Mantencion {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMantencion;

    @NotNull(message = "La fecha de mantención es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaUltimaMantencion;

    @NotNull(message = "La vigencia es obligatoria")
    @Column(nullable = false)
    private Integer vigenciaMeses;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(nullable = false, length = 300)
    private String descripcion;

    @NotBlank(message = "El estado es obligatorio")
    @Column(nullable = false, length = 50)
    private String estado;
}
