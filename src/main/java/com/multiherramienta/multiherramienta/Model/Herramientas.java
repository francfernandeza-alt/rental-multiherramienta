package com.multiherramienta.multiherramienta.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Integer idHerramientas;

    @ManyToOne
    @JoinColumn(name = "idHerrramienta", nullable = false)
    private Herramienta herramienta;

    @ManyToOne
    @JoinColumn(name = "idReserva", nullable = false)
    private Reserva reserva;
}
