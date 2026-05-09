package com.multiherramienta.multiherramienta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiherramienta.multiherramienta.DTO.UsuarioDTO;
import com.multiherramienta.multiherramienta.Model.Usuario;
import com.multiherramienta.multiherramienta.Services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> todosLosUsuarios() {
        List<UsuarioDTO> usuario = usuarioService.obtenerTodos();
        if (usuario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<UsuarioDTO> buscarPorRut(@PathVariable String rut) {
        try {
            UsuarioDTO us = usuarioService.buscarporId(rut);
            return new ResponseEntity<>(us, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario guardado = usuarioService.guardarUsuario(usuario);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{rut}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable String rut, @RequestBody Usuario usuario) {
        try {
            Usuario editado = usuarioService.guardarUsuario(usuario);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{rut}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String rut, @RequestBody Usuario usuario){
        try{
            Usuario newUser = usuarioService.actualizarUsuario( rut, usuario);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String rut) {
        String resultado = usuarioService.eliminar(rut);
        if (resultado.contains("eliminado")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
