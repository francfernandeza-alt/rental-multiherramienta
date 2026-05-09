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
    public ResponseEntity<?> listarTiposHerramienta() {
        List<TipoHerramienta> tiposHerramienta = tipoHerramientaService.findAll();

        if (tiposHerramienta.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tiposHerramienta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTipoHerramienta(@PathVariable Integer id) {
        TipoHerramienta tipoHerramienta = tipoHerramientaService.findById(id);

        if (tipoHerramienta != null) {
            return new ResponseEntity<>(tipoHerramienta, HttpStatus.OK);
        }

        return new ResponseEntity<>("Tipo de herramienta no encontrado", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crearTipoHerramienta(@Valid @RequestBody TipoHerramienta tipoHerramienta) {
        TipoHerramienta nuevoTipoHerramienta = tipoHerramientaService.save(tipoHerramienta);

        if (nuevoTipoHerramienta != null) {
            return new ResponseEntity<>(nuevoTipoHerramienta, HttpStatus.CREATED);
        }

        return new ResponseEntity<>("No se pudo crear el tipo de herramienta", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTipoHerramienta(@PathVariable Integer id,@Valid @RequestBody TipoHerramienta tipoHerramienta) {
        TipoHerramienta tipoHerramientaActualizado = tipoHerramientaService.actualizarTipoHerramienta(id, tipoHerramienta);

        if (tipoHerramientaActualizado != null) {
            return new ResponseEntity<>(tipoHerramientaActualizado, HttpStatus.OK);
        }

        return new ResponseEntity<>("Tipo de herramienta no encontrado", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTipoHerramienta(@PathVariable Integer id) {
        String resultado = tipoHerramientaService.delete(id);

        if (resultado.contains("correctamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
    }
}