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
    public ResponseEntity<List<Comuna>> listarComunas() {
        List<Comuna> comunas = comunaService.findAll();

        if (comunas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(comunas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> buscarComuna(@PathVariable Integer id) {
        Comuna comuna = comunaService.findById(id);

        if (comuna != null) {
            return new ResponseEntity<>(comuna, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Comuna> crearComuna(@Valid @RequestBody Comuna comuna) {
        Comuna nuevaComuna = comunaService.save(comuna);

        if (nuevaComuna != null) {
            return new ResponseEntity<>(nuevaComuna, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> actualizarComuna(@PathVariable Integer id, @Valid @RequestBody Comuna comuna) {
        Comuna comunaEncontrada = comunaService.findById(id);

        if (comunaEncontrada != null) {
            comunaEncontrada.setNombreComuna(comuna.getNombreComuna());
            comunaEncontrada.setRegion(comuna.getRegion());

            Comuna comunaActualizada = comunaService.save(comunaEncontrada);
            return new ResponseEntity<>(comunaActualizada, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarComuna(@PathVariable Integer id) {
        Comuna comuna = comunaService.findById(id);

        if (comuna != null) {
            comunaService.delete(id);
            return new ResponseEntity<>("Comuna eliminada", HttpStatus.OK);
        }

        return new ResponseEntity<>("Comuna no encontrada", HttpStatus.NOT_FOUND);
    }
}