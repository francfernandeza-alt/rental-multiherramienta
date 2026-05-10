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


@RestController
@RequestMapping("/api/v1/tipopago")
public class TipoPagoController {

    @Autowired
    private TipoPagoServices tipoPagoServices;

    @GetMapping
    public ResponseEntity<List<TipoPago>> todooLosTipoPago() {
        List<TipoPago> tipoPago = tipoPagoServices.obtenerTodos();
        if (tipoPago.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tipoPago, HttpStatus.OK);
    }

    @GetMapping("/tipopago/{id}")
    public ResponseEntity<TipoPago> buscarPorId(@PathVariable Integer id) {
        try {
            TipoPago tipoPago = tipoPagoServices.buscarPorId(id);
            return new ResponseEntity<>(tipoPago, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoPago> agregarTipoPago(@RequestBody TipoPago tipoPago) {
        try {
            TipoPago guardado = tipoPagoServices.guardarTipoPago(tipoPago);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/tipopago/{id}")
    public ResponseEntity<TipoPago> editarUsuario(@PathVariable Integer id, @RequestBody TipoPago tipoPago) {
        try {
            TipoPago editada = tipoPagoServices.guardarTipoPago(tipoPago);
            return new ResponseEntity<>(editada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/tipopago/{id}")
    public ResponseEntity<TipoPago> actualizarTipoPago(@PathVariable Integer id, @RequestBody TipoPago tipoPago){
        try{
            TipoPago nuevo = tipoPagoServices.actualizarTipoPago(id, tipoPago);
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tipopago/{id}")
    public ResponseEntity<String> eliminarTipoPago(@PathVariable Integer id) {
        String resultado = tipoPagoServices.eliminar(id);
        if (resultado.contains("eliminado")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
