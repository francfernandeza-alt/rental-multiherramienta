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

import com.multiherramienta.multiherramienta.DTO.MarcaDTO;
import com.multiherramienta.multiherramienta.Model.Marca;
import com.multiherramienta.multiherramienta.Services.MarcaService;

@RestController
@RequestMapping("/api/v1/marca")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> todosLasMarcas() {
        List<MarcaDTO> marca = marcaService.obtenerTodos();
        if (marca.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(marca, HttpStatus.OK);
    }

    @GetMapping("/marca/{id}")
    public ResponseEntity<MarcaDTO> buscarPorId(@PathVariable Integer id) {
        try {
            MarcaDTO mar = marcaService.buscarporId(id);
            return new ResponseEntity<>(mar, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Marca> agregarUsuario(@RequestBody Marca marca) {
        try {
            Marca guardada = marcaService.guardarMarca(marca);
            return new ResponseEntity<>(guardada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/marca/{id}")
    public ResponseEntity<Marca> editarUsuario(@PathVariable Integer id, @RequestBody Marca marca) {
        try {
            Marca editada = marcaService.guardarMarca(marca);
            return new ResponseEntity<>(editada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/marca/{id}")
    public ResponseEntity<Marca> actualizarMarca(@PathVariable Integer id, @RequestBody Marca marca){
        try{
            Marca nuevaMarca = marcaService.actualizarMarca(id, marca);
            return new ResponseEntity<>(nuevaMarca, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/marca/{id}")
    public ResponseEntity<String> eliminarMarca(@PathVariable Integer id) {
        String resultado = marcaService.eliminar(id);
        if (resultado.contains("eliminada")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
