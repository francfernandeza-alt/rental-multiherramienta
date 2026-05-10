package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Comuna;
import com.multiherramienta.multiherramienta.Repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> obtenerTodas() {
        return comunaRepository.findAll();
    }

    public Comuna buscarPorId(Integer id) {
        return comunaRepository.findById(id).orElse(null);
    }

    public Comuna guardarComuna(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    public String eliminar(Integer id) {
        Comuna comuna = comunaRepository.findById(id).orElse(null);

        if (comuna != null) {
            comunaRepository.delete(comuna);
            return "Comuna eliminada correctamente";
        }

        return "Comuna no encontrada";
    }

    public Comuna actualizarComuna(Integer id, Comuna comuna) {
        Comuna comunaEncontrada = comunaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comuna no encontrada"));

        comunaEncontrada.setNombreComuna(comuna.getNombreComuna());
        comunaEncontrada.setRegion(comuna.getRegion());

        return comunaRepository.save(comunaEncontrada);
    }

}