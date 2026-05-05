package com.multiherramienta.multiherramienta.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "Region")
public class Region {

    @Id
    @NotNull(message= "El id de la región es obligatorio")
    @Column(nullable = false)
    private Integer numeroRegion;

    @NotBlank(message = "El nombre de la región es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre de la region debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombreRegion;
    
}
