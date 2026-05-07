package com.multiherramienta.multiherramienta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.multiherramienta.multiherramienta.Model.Usuario;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Direccion")
public class Direccion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;

    @NotBlank(message = "La calle es obligatoria")
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String calle;

    @NotNull(message = "La numeración es obligatoria")
    @Column(nullable = false)
    private Integer numeracion;

    @NotBlank(message = "La comuna es obligatoria")
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String comuna;

    @OneToOne
    @JoinColumn(name = "rutUsuario")
    private Usuario usuario;

}
