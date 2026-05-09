package com.multiherramienta.multiherramienta.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.multiherramienta.multiherramienta.Model.TipoPago;
import com.multiherramienta.multiherramienta.Services.TipoPagoServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tipopagos")
public class TipoPagoController {
    @Autowired
    private TipoPagoServices service;

    @GetMapping
    public ResponseEntity<List<TipoPago>> listar() {
        List<TipoPago> lista = service.findAll();
        if (lista.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPago> buscar(@PathVariable Integer id) {
        TipoPago obj = service.findById(id);
        if (obj != null) return new ResponseEntity<>(obj, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TipoPago> crear(@Valid @RequestBody TipoPago obj) {
        return new ResponseEntity<>(service.save(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPago> actualizar(@PathVariable Integer id, @RequestBody TipoPago data) {
        TipoPago obj = service.findById(id);
        if (obj == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        obj.setNombre(data.getNombre());

        return new ResponseEntity<>(service.save(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
}
