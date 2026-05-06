package com.multiherramienta.multiherramienta.Model;

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
@Table(name = "TiposHerramienta")
public class TiposHerramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTiposHerramienta;

    @NotNull(message = "La herramienta es obligatoria")
    @ManyToOne
    @JoinColumn(name = "idHerramienta", nullable = false)
    private Herramienta herramienta;

    @NotNull(message = "El tipo de herramienta es obligatorio")
    @ManyToOne
    @JoinColumn(name = "idTipoHerramienta", nullable = false)
    private TipoHerramienta tipoHerramienta;
}