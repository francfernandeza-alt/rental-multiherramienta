
package com.multiherramienta.multiherramienta.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Usuario")

public class Usuario {

    @Id
    @NotNull
    private String rutUsuario;

    @NotBlank (message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombreUsuario;

    @NotBlank (message = "El apellido paterno es obligatorio")
    @Size(min = 3, max = 50, message = "El apellido paterno debe tener entre 3 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String apellidoPaterno;

    @NotBlank (message = "El apellido materno es obligatorio")
    @Size(min = 3, max = 50, message = "El apellido materno debe tener entre 3 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String apellidoMaterno;

    @NotBlank (message = "El tipo de usuario es obligatorio")
    @Size(min = 5, max = 20, message = "El tipo de usuario debe tener entre 5 y 20 caracteres")
    @Column(nullable = false, length = 20)
    private String tipoUsuario;

    @NotBlank (message = "El email es obligatorio")
    @Size(min = 13, max = 100, message = "El email debe tener entre 13 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String emailUsuario;

    @NotBlank (message = "La contraseña es obligatoria")
    @Size(min = 8, max = 8, message = "La contraseña debe tener 8 caracteres")
    @Column(nullable = false, length = 8)
    private String contraseñaUsuario;
    
    @OneToMany(mappedBy = "usuario")
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;
}
