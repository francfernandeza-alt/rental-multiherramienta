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

import com.multiherramienta.multiherramienta.Model.Region;
import com.multiherramienta.multiherramienta.Services.RegionService;


@RestController
@RequestMapping("/api/v1/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> todosLasRegiones() {
        List<Region> region = regionService.obtenerTodos();
        if (region.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(region, HttpStatus.OK);
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<Region> buscarPorId(@PathVariable Integer id) {
        try {
            Region region = regionService.buscarporId(id);
            return new ResponseEntity<>(region, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Region> agregarRegion(@RequestBody Region region) {
        try {
            Region guardada = regionService.guardarRegion(region);
            return new ResponseEntity<>(guardada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/region/{id}")
    public ResponseEntity<Region> editarRegion(@PathVariable Integer id, @RequestBody Region region) {
        try {
            Region editada = regionService.guardarRegion(region);
            return new ResponseEntity<>(editada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/region/{id}")
    public ResponseEntity<Region> actualizarRegion(@PathVariable Integer id, @RequestBody Region region){
        try{
            Region nuevo = regionService.actualizarRegion(id, region);
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/region/{id}")
    public ResponseEntity<String> eliminarRegion(@PathVariable Integer id) {
        String resultado = regionService.eliminar(id);
        if (resultado.contains("eliminada")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}


