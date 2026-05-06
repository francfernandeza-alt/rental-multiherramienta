package com.multiherramienta.multiherramienta.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "Herramientas")
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHerramienta;

    @NotBlank (message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombreHerramienta;

    @NotBlank (message = "La marca es obligatoria")
    @Size(min = 3, max = 50, message = "La marca debe tener entre 3 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String marcaHerramienta;

    @NotBlank (message = "La descripción es obligatoria")
    @Size(min = 20, max = 500, message = "La descripción debe tener entre 20 y 500 caracteres")
    @Column(nullable = false, length = 500)
    private String descripcionHerramienta;

    @NotBlank (message = "El tipo de Herramienta es obligatorio")
    @Size(min = 5, max = 50, message = "El tipo de herramienta debe tener entre 5 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String tipoHerramienta;

    @NotBlank (message = "El estado es obligatorio")
    @Size(min = 2, max = 100, message = "El estado debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String estadoHerramienta;

    @OneToMany(mappedBy = "herramienta")
    private List<Materiales> materiales;

    @OneToMany(mappedBy = "herramienta")
    private List<TiposHerramienta> tiposHerramienta;
}
