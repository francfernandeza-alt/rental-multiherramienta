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

import com.multiherramienta.multiherramienta.Model.Material;
import com.multiherramienta.multiherramienta.Services.MaterialService;
import com.multiherramienta.multiherramienta.DTO.MaterialDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public ResponseEntity<?> listarMateriales() {
        List<MaterialDTO> materiales = materialService.findAll();

        if (materiales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(materiales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMaterial(@PathVariable Integer id) {
        try {
            MaterialDTO material = materialService.findById(id);
            return new ResponseEntity<>(material, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Material no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> crearMaterial(@Valid @RequestBody Material material) {
        try {
            MaterialDTO nuevoMaterial = materialService.save(material);
            return new ResponseEntity<>(nuevoMaterial, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("No se pudo crear el material", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMaterial(@PathVariable Integer id, @Valid @RequestBody Material material) {
        try {
            MaterialDTO materialActualizado = materialService.actualizarMaterial(id, material);
            return new ResponseEntity<>(materialActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Material no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMaterial(@PathVariable Integer id) {
        String resultado = materialService.delete(id);

        if (resultado.contains("correctamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
    }
}