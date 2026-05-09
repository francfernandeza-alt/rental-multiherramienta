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
@Table(name = "Inventario")

public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInventario;

    @NotBlank (message = "La ubicación es obligatoria")
    @Size(min = 6, max = 10, message = "La ubicación debe tener entre 6 y 10 caracteres")
    @Column(nullable = false, length = 10)
    private String ubicación;

    @NotNull
    @Column(nullable = false, length = 4)
    private Integer cantidadTotal;

    @NotNull
    @Column(nullable = false, length = 4)
    private Integer cantidadDisponible;

    @OneToOne
    @JoinColumn(name = "idHerramienta")
    private Herramienta herramienta;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaUltimaActualizacion;
}
