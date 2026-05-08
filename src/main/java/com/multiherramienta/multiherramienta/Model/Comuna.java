package com.multiherramienta.multiherramienta.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "Comuna")
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComuna;

    @NotBlank(message = "El nombre de la comuna es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre de la comuna debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombreComuna;

    @NotNull(message = "La región es obligatoria")
    @ManyToOne
    @JoinColumn(name = "numeroRegion", nullable = false)
    private Region region;

    @OneToMany(mappedBy = "comuna")
    private List<Direccion> direcciones;
}