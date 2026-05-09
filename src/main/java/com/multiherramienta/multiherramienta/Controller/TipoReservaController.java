package com.multiherramienta.multiherramienta.Controller;

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

import com.multiherramienta.multiherramienta.Model.TipoReserva;
import com.multiherramienta.multiherramienta.Services.TipoReservaService;

@RestController
@RequestMapping("/api/v1/tiporeservas")
public class TipoReservaController {

 @Autowired
    private TipoReservaService service;

    @GetMapping
    public ResponseEntity<List<TipoReserva>> listar() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoReserva> buscar(@PathVariable Integer id) {
        TipoReserva obj = service.findById(id);
        if (obj != null) return new ResponseEntity<>(obj, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TipoReserva> crear(@RequestBody TipoReserva obj) {
        return new ResponseEntity<>(service.save(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoReserva> actualizar(@PathVariable Integer id, @RequestBody TipoReserva data) {
        TipoReserva obj = service.findById(id);
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
