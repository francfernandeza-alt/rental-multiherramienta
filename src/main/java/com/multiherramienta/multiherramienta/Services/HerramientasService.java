package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Herramientas;
import com.multiherramienta.multiherramienta.Repository.HerramientasRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HerramientasService {
    
    @Autowired
    public HerramientasRepository herramientasRepository;

    public Herramientas guardar(Herramientas herramienta) {
        return herramientasRepository.save(herramienta);
    }

    public List<Herramientas> obtenerTodas() {
        return herramientasRepository.findAll();
    }

    public String eliminar(Integer id) {
        try {
            Herramientas herramientas = herramientasRepository.findById(id).orElseThrow(() -> new RuntimeException("Herramienta con Id  " + id + " no existe."));
            herramientasRepository.delete(herramientas);
            return "La herramienta con Id '" + herramientas.getIdHerramientas() + " ha sido eliminada.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public List<String> obtenerResenasConUsuario() {
        return herramientasRepository.findAll().stream().map(nexo -> {String nombreUsuario = "";
        if (nexo.getReserva() != null && nexo.getReserva().getUsuario() != null) {
            nombreUsuario = nexo.getReserva().getUsuario().getNombreUsuario();
        }
        return "Reseña: " + nexo.getReseña() +" Puntuación: " + nexo.getPuntuacion() + "Usuario: " + nombreUsuario;
        })
        .toList();
    }
}