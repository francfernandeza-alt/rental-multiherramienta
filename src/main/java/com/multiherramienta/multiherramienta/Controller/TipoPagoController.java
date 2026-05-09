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
    public ResponseEntity<TipoPago> actualizar(@PathVariable Integer id, @RequestBody TipoPago tipopago) {
        TipoPago obj = service.findById(id);
        if (obj == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        obj.setIdTipoPago(tipopago.getIdTipoPago());
        obj.setMetodoPago(tipopago.getMetodoPago());


        return new ResponseEntity<>(service.save(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
}
