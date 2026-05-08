package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, String> {

}
