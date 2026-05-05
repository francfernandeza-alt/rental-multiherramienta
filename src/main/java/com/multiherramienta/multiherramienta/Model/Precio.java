package com.multiherramienta.multiherramienta.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Precios")

public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrecio;

    @NotNull
    @Column(nullable = false, length = 7)
    private Integer valorDiario;

    @NotNull
    @Column(nullable = false, length = 7)
    private Integer valorHora;

    @ManyToOne
    @JoinColumn(name = "idHerramienta")
    private Herramienta herramienta;

}
