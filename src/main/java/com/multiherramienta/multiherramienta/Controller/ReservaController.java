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

import com.multiherramienta.multiherramienta.DTO.ReservaDTO;
import com.multiherramienta.multiherramienta.Model.Reserva;
import com.multiherramienta.multiherramienta.Services.ReservaService;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> todosLasReservas() {
        List<ReservaDTO> reserva = reservaService.obtenerTodos();
        if (reserva.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<ReservaDTO> buscarPorId(@PathVariable Integer numReserva) {
        try {
            ReservaDTO res = reservaService.buscarpornumReserva(numReserva);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Reserva> agregarReserva(@RequestBody Reserva reserva) {
        try {
            Reserva guardada = reservaService.guardarReserva(reserva);
            return new ResponseEntity<>(guardada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/reservas/{id}")
    public ResponseEntity<Reserva> editarReserva(@PathVariable Integer numReserva, @RequestBody Reserva reserva) {
        try {
            Reserva editada = reservaService.guardarReserva(reserva);
            return new ResponseEntity<>(editada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reservas/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Integer numReserva, @RequestBody Reserva reserva){
        try{
            Reserva nuevaReserva = reservaService.actualizarReserva(numReserva, reserva);
            return new ResponseEntity<>(nuevaReserva, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reserva/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable Integer numReserva) {
        String resultado = reservaService.eliminar(numReserva);
        if (resultado.contains("eliminada")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
