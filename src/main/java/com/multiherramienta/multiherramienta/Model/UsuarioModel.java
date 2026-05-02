
package com.multiherramienta.multiherramienta.Model;

import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")

public class UsuarioModel {

    private String nombreUsuario;
}
