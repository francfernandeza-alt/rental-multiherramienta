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

import com.multiherramienta.multiherramienta.Model.Comuna;
import com.multiherramienta.multiherramienta.Services.ComunaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/comunas")
public class ComunaController {

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<?> listarComunas() {
        List<Comuna> comunas = comunaService.findAll();

        if (comunas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(comunas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarComuna(@PathVariable Integer id) {
        try {
            Comuna comuna = comunaService.findById(id);
            return new ResponseEntity<>(comuna, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>("Comuna no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> crearComuna(@Valid @RequestBody Comuna comuna) {
        try {
            Comuna nuevaComuna = comunaService.save(comuna);
            return new ResponseEntity<>(nuevaComuna, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("No se pudo crear la comuna", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarComuna(@PathVariable Integer id, @Valid @RequestBody Comuna comuna) {
        try {
            Comuna comunaActualizada = comunaService.actualizarComuna(id, comuna);
            return new ResponseEntity<>(comunaActualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Comuna no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarComuna(@PathVariable Integer id) {
        String resultado = comunaService.delete(id);

        if (resultado.contains("correctamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
    }
}