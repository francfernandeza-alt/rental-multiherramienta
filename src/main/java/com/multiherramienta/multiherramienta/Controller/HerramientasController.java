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
@RequestMapping("/api/v1/herramientas-reservadas")
public class HerramientasController {

    @Autowired
    private HerramientasService herramientasService;

    @GetMapping
    public ResponseEntity<?> listarHerramientasReservadas() {
        List<Herramientas> herramientasReservadas = herramientasService.obtenerTodas();

        if (herramientasReservadas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(herramientasReservadas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarHerramientaReservadaPorId(@PathVariable Integer id) {
        try {
            Herramientas herramientaReservada = herramientasService.buscarPorId(id);
            return new ResponseEntity<>(herramientaReservada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Herramienta reservada no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarHerramientaReservada(@Valid @RequestBody Herramientas herramientaReservada) {
        try {
            Herramientas guardada = herramientasService.guardar(herramientaReservada);
            return new ResponseEntity<>(guardada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("No se pudo agregar la herramienta reservada", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarHerramientaReservada(@PathVariable Integer id) {
        String resultado = herramientasService.eliminar(id);

        if (resultado.contains("eliminada")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/usuario/{rutUsuario}")
    public ResponseEntity<?> herramientasReservadasPorRutUsuario(@PathVariable String rutUsuario) {
        List<String> herramientasReservadas = herramientasService.herramientasPorRutUsuario(rutUsuario);

        if (herramientasReservadas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(herramientasReservadas, HttpStatus.OK);
    }
}