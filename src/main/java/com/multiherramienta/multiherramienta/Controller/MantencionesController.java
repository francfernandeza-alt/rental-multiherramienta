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

import com.multiherramienta.multiherramienta.Model.Mantenciones;
import com.multiherramienta.multiherramienta.Services.MantencionesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/mantenciones")
public class MantencionesController {

    @Autowired
    private MantencionesService mantencionesService;

    @GetMapping
    public ResponseEntity<?> listarMantenciones() {
        List<Mantenciones> mantenciones = mantencionesService.findAll();

        if (mantenciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(mantenciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMantenciones(@PathVariable Integer id) {
        Mantenciones mantenciones = mantencionesService.findById(id);

        if (mantenciones != null) {
            return new ResponseEntity<>(mantenciones, HttpStatus.OK);
        }

        return new ResponseEntity<>("Relación mantención-herramienta no encontrada", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crearMantenciones(@Valid @RequestBody Mantenciones mantenciones) {
        Mantenciones nuevaMantenciones = mantencionesService.save(mantenciones);

        if (nuevaMantenciones != null) {
            return new ResponseEntity<>(nuevaMantenciones, HttpStatus.CREATED);
        }

        return new ResponseEntity<>("No se pudo crear la relación mantención-herramienta", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMantenciones(@PathVariable Integer id, @Valid @RequestBody Mantenciones mantenciones) {
        Mantenciones mantencionesActualizada = mantencionesService.actualizarMantenciones(id, mantenciones);

        if (mantencionesActualizada != null) {
            return new ResponseEntity<>(mantencionesActualizada, HttpStatus.OK);
        }

        return new ResponseEntity<>("Relación mantención-herramienta no encontrada", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMantenciones(@PathVariable Integer id) {
        String resultado = mantencionesService.delete(id);

        if (resultado.contains("correctamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
    }
}
