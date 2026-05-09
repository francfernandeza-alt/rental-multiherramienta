package com.multiherramienta.multiherramienta.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiherramienta.multiherramienta.DTO.DireccionDTO;
import com.multiherramienta.multiherramienta.Model.Direccion;
import com.multiherramienta.multiherramienta.Services.DireccionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/direcciones")
public class DireccionController {
    
    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<DireccionDTO> lista = direccionService.findAll();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        DireccionDTO direccion = direccionService.findById(id);

        if (direccion != null) {
            return new ResponseEntity<>(direccion, HttpStatus.OK);
        }

        return new ResponseEntity<>("Dirección no encontrada", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Direccion direccion) {
        Direccion nueva = direccionService.save(direccion);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Direccion direccion) {
        Direccion direccionActualizada = direccionService.actualizarDireccion(id, direccion);

        if (direccionActualizada != null) {
            return new ResponseEntity<>(direccionActualizada, HttpStatus.OK);
        }

        return new ResponseEntity<>("Dirección no encontrada", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        String resultado = direccionService.delete(id);

        if (resultado.contains("correctamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
    }
}
