package com.multiherramienta.multiherramienta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TipoMantencion")
public class Mantenciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoMantencion;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100, unique = true)
    private String nombre;
    
}

