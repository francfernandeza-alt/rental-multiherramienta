package com.multiherramienta.multiherramienta.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Reserva")

public class Reserva {

    @Id
    @NotNull
    private Integer numeroReserva;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechafin;

    @NotBlank (message = "El estado es obligatorio")
    @Size(min = 2, max = 50, message = "El estado debe tener entre 2 y 50 caracteres")
    @Column(nullable = false, length = 100)
    private String estadoReserva;

    @ManyToOne
    @JoinColumn(name= "rutUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name= "idHerramienta", nullable = false)
    private Herramienta herramienta;

}
