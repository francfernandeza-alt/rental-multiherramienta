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

import com.multiherramienta.multiherramienta.Model.TipoPago;
import com.multiherramienta.multiherramienta.Services.TipoPagoServices;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/tipopago")
public class TipoPagoController {

    @Autowired
    private TipoPagoServices tipoPagoServices;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<TipoPago> lista = tipoPagoServices.obtenerTodos();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        TipoPago tipoPago = tipoPagoServices.buscarPorId(id);

        if (tipoPago != null) {
            return new ResponseEntity<>(tipoPago, HttpStatus.OK);
        }
        return new ResponseEntity<>("Tipo de pago no encontrado", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody TipoPago tipoPago) {
        TipoPago nuevoTipoPago = tipoPagoServices.guardarTipoPago(tipoPago);

        if (nuevoTipoPago != null) {
            return new ResponseEntity<>(nuevoTipoPago, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No se pudo crear el tipo de pago", HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable Integer id, @RequestBody TipoPago tipoPago) {
        try {
            TipoPago editada = tipoPagoServices.guardarTipoPago(tipoPago);
            return new ResponseEntity<>(editada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @Valid @RequestBody TipoPago tipoPago) {
        TipoPago tipoPagoActualizado = tipoPagoServices.actualizarTipoPago(id, tipoPago);

        if (tipoPagoActualizado != null) {
            return new ResponseEntity<>(tipoPagoActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>("Tipo de pago no encontrado", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        String resultado = tipoPagoServices.eliminar(id);

        if (resultado.contains("correctamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }
        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
    }
}
