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

import com.multiherramienta.multiherramienta.Model.TipoHerramienta;
import com.multiherramienta.multiherramienta.Services.TipoHerramientaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tipos-herramienta")
public class TipoHerramientaController {

    @Autowired
    private TipoHerramientaService tipoHerramientaService;

    @GetMapping
    public ResponseEntity<List<TipoHerramienta>> listarTiposHerramienta() {
        List<TipoHerramienta> tiposHerramienta = tipoHerramientaService.findAll();

        if (tiposHerramienta.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tiposHerramienta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHerramienta> buscarTipoHerramienta(@PathVariable Integer id) {
        TipoHerramienta tipoHerramienta = tipoHerramientaService.findById(id);

        if (tipoHerramienta != null) {
            return new ResponseEntity<>(tipoHerramienta, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TipoHerramienta> crearTipoHerramienta(@Valid @RequestBody TipoHerramienta tipoHerramienta) {
        TipoHerramienta nuevoTipoHerramienta = tipoHerramientaService.save(tipoHerramienta);

        if (nuevoTipoHerramienta != null) {
            return new ResponseEntity<>(nuevoTipoHerramienta, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoHerramienta> actualizarTipoHerramienta(@PathVariable Integer id,@Valid @RequestBody TipoHerramienta tipoHerramienta) {

        TipoHerramienta tipoHerramientaEncontrado = tipoHerramientaService.findById(id);

        if (tipoHerramientaEncontrado != null) {
            tipoHerramientaEncontrado.setNombreTipoHerramienta(tipoHerramienta.getNombreTipoHerramienta());
            tipoHerramientaEncontrado.setDescripcionTipoHerramienta(tipoHerramienta.getDescripcionTipoHerramienta());

            TipoHerramienta tipoHerramientaActualizado = tipoHerramientaService.save(tipoHerramientaEncontrado);
            return new ResponseEntity<>(tipoHerramientaActualizado, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoHerramienta(@PathVariable Integer id) {
        TipoHerramienta tipoHerramienta = tipoHerramientaService.findById(id);

        if (tipoHerramienta != null) {
            tipoHerramientaService.delete(id);
            return new ResponseEntity<>("Tipo de herramienta eliminado", HttpStatus.OK);
        }

        return new ResponseEntity<>("Tipo de herramienta no encontrado", HttpStatus.NOT_FOUND);
    }
}