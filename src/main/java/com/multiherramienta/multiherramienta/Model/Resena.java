package com.multiherramienta.multiherramienta.Model;

import java.time.LocalDateTime;

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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reseñas")

public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReseña;

    @NotNull
    @Column(nullable = false, length = 1)
    private Integer puntuacion;

    @Size(min = 2, max = 500, message = "El comentario debe tener entre 2 y 500 caracteres")
    @Column(length = 500)
    private String comentario;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaResena;

    @ManyToOne
    @JoinColumn(name = "rutUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idHerramienta")
    private Herramienta herramienta;

}
