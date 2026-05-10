package com.multiherramienta.multiherramienta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiherramienta.multiherramienta.Model.TipoReserva;
import com.multiherramienta.multiherramienta.Services.TipoReservaService;

@RestController
@RequestMapping("/api/v1/tiporeserva")
public class TipoReservaController {

    @Autowired
    private TipoReservaService tipoReservaService;

    @GetMapping
    public ResponseEntity<List<TipoReserva>> todosLasReservas() {
        List<TipoReserva> tipoReserva = tipoReservaService.obtenerTodos();
        if (tipoReserva.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tipoReserva, HttpStatus.OK);
    }

    @GetMapping("/tiporeserva/{id}")
    public ResponseEntity<TipoReserva> buscarPorId(@PathVariable Integer id) {
        try {
            TipoReserva tipoReserva = tipoReservaService.buscarPorId(id);
            return new ResponseEntity<>(tipoReserva, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoReserva> agregarTipoReserva(@RequestBody TipoReserva tipoReserva) {
        try {
            TipoReserva guardada = tipoReservaService.guardarTipoReserva(tipoReserva);
            return new ResponseEntity<>(guardada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/tiporeserva/{id}")
    public ResponseEntity<TipoReserva> editarTipoReserva(@PathVariable Integer id, @RequestBody TipoReserva tipoReserva) {
        try {
            TipoReserva editada = tipoReservaService.guardarTipoReserva(tipoReserva);
            return new ResponseEntity<>(editada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/tiporeserva/{id}")
    public ResponseEntity<TipoReserva> actualizarTipoReserva(@PathVariable Integer id, @RequestBody TipoReserva tipoReserva){
        try{
            TipoReserva nuevo = tipoReservaService.actualizarTipoReserva(id, tipoReserva);
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tiporeserva/{id}")
    public ResponseEntity<String> eliminarMarca(@PathVariable Integer id) {
        String resultado = tipoReservaService.eliminar(id);
        if (resultado.contains("eliminado")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
