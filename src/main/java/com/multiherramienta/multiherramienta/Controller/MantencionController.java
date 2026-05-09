package com.multiherramienta.multiherramienta.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.multiherramienta.multiherramienta.Model.Mantencion;
import com.multiherramienta.multiherramienta.Services.MantencionServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/mantenciones")
public class MantencionController {
@Autowired
    private MantencionServices mantencionService;

    @GetMapping
    public ResponseEntity<List<Mantencion>> listar() {
        List<Mantencion> lista = mantencionService.findAll();
        if (lista.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mantencion> buscar(@PathVariable Integer id) {
        Mantencion obj = mantencionService.findById(id);
        if (obj != null) return new ResponseEntity<>(obj, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Mantencion> crear(@Valid @RequestBody Mantencion mantencion) {
        return new ResponseEntity<>(mantencionService.save(mantencion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mantencion> actualizar(@PathVariable Integer id, @RequestBody Mantencion data) {
        Mantencion obj = mantencionService.findById(id);
        if (obj == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        obj.setNombre(data.getNombre()); // ajusta según tu modelo
        obj.setDescripcion(data.getDescripcion());

        return new ResponseEntity<>(mantencionService.save(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        Mantencion obj = mantencionService.findById(id);
        if (obj == null) return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);

        mantencionService.delete(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
}
}
