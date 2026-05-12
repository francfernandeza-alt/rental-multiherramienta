package com.multiherramienta.multiherramienta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiherramienta.multiherramienta.Model.Herramientas;
import com.multiherramienta.multiherramienta.Services.HerramientasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/reseña")
public class HerramientasController {

    @Autowired
    private HerramientasService herramientasService;

    @GetMapping
    public ResponseEntity<List<Herramientas>> todosLasReseñas() {
        List<Herramientas> reseña = herramientasService.obtenerTodas();
        if (reseña.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reseña, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Herramientas> buscarporId(@PathVariable Integer id) {
        try {
            Herramientas her = herramientasService.buscarPorId(id);
            return new ResponseEntity<>(her, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Herramientas> agregarReseña(@RequestBody Herramientas reseña) {
        try {
            Herramientas guardado = herramientasService.guardar(reseña);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReseña(@PathVariable Integer id) {
        String resultado = herramientasService.eliminar(id);
        if (resultado.contains("eliminada")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reseñas/{rutUsuario}")
    public ResponseEntity<List<String>> reseñasPorUsuario(@PathVariable String rutUsuario) {
        List<String> reseñas = herramientasService.reseñaPorRutUsuario(rutUsuario);

        if (reseñas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reseñas, HttpStatus.OK);
    }
}