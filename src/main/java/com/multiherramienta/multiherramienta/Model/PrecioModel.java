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
@Table(name = "Precios")

public class PrecioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrecio;

    @NotNull
    private Integer valorDiario;

    @NotNull
    private Integer valorHora;

    @ManyToOne
    @JoinColumn(name = "idHerramienta")
    private HerramientaModel herramienta;

}
