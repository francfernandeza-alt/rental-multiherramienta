package com.multiherramienta.multiherramienta.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Herramientas")
public class Herramientas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHerramientas;

    @NotNull
    @Column(nullable = false)
    private Integer puntuacion;

    @NotBlank(message = "La reseña es obligatoria")
    @Size(min = 2, max = 1000, message = "La reseña debe tener entre 2 y 1000 caracteres")
    @Column(nullable = false, length = 1000)
    private String reseña;

    @NotBlank(message = "El nombre usuario es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre usuario debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombreCompletoUsuario;

    @ManyToOne
    @JoinColumn(name = "idHerramienta", nullable = false)
    private Herramienta herramienta;

    @ManyToOne
    @JoinColumn(name = "idReserva", nullable = false)
    private Reserva reserva;
}
