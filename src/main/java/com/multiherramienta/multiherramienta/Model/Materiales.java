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
@Table(name = "Materiales")
public class Materiales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMateriales;

    @NotNull(message = "La herramienta es obligatoria")
    @ManyToOne
    @JoinColumn(name = "idHerramienta", nullable = false)
    private Herramienta herramienta;

    @NotNull(message = "El material es obligatorio")
    @ManyToOne
    @JoinColumn(name = "idMaterial", nullable = false)
    private Material material;
}