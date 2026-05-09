package com.multiherramienta.multiherramienta.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.multiherramienta.multiherramienta.Model.Direccion;
import com.multiherramienta.multiherramienta.Services.DireccionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/direcciones")
public class DireccionController {
@Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> listar() {
        List<Direccion> lista = direccionService.findAll();
        if (lista.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> buscar(@PathVariable Integer id) {
        Direccion obj = direccionService.findById(id);
        if (obj != null) return new ResponseEntity<>(obj, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Direccion> crear(@Valid @RequestBody Direccion direccion) {
        Direccion nueva = direccionService.save(direccion);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> actualizar(@PathVariable Integer id, @RequestBody Direccion data) {
        Direccion obj = direccionService.findById(id);

        if (obj == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // ajusta según tu modelo real
        obj.setCalle(data.getCalle());
        obj.setNumero(data.getNumero());
        obj.setComuna(data.getComuna());

        return new ResponseEntity<>(direccionService.save(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        Direccion obj = direccionService.findById(id);

        if (obj == null) {
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        }

        direccionService.delete(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
}
