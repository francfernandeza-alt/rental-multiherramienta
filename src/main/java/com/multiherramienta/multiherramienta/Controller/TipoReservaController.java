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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tiporeserva")
public class TipoReservaController {

    @Autowired
    private TipoReservaService tipoReservaService;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<TipoReserva> lista = tipoReservaService.obtenerTodos();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        TipoReserva tipoReserva = tipoReservaService.buscarPorId(id);

        if(tipoReserva != null){
            return new ResponseEntity<>(tipoReserva, HttpStatus.OK);
        }
        return new ResponseEntity<>("Tipo de reserva no encontrado", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> agregarTipoReserva(@RequestBody TipoReserva tipoReserva) {
        TipoReserva nuevaTipoReserva = tipoReservaService.guardarTipoReserva(tipoReserva);

        if(nuevaTipoReserva != null){
            return new ResponseEntity<>(nuevaTipoReserva, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No se pudo crear el tipo de reserva", HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editarTipoReserva(@PathVariable Integer id, @RequestBody TipoReserva tipoReserva) {
        try {
            TipoReserva editada = tipoReservaService.guardarTipoReserva(tipoReserva);
            return new ResponseEntity<>(editada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @Valid @RequestBody TipoReserva tipoReserva) {
        TipoReserva tipoReservaActualizado = tipoReservaService.actualizarTipoReserva(id, tipoReserva);

        if (tipoReservaActualizado != null) {
            return new ResponseEntity<>(tipoReservaActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>("Tipo de reserva no encontrado", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        String resultado = tipoReservaService.eliminar(id);

        if (resultado.contains("correctamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }
        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
    }
}
