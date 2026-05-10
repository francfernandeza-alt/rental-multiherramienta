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

    public Herramientas buscarPorId(Integer id) {
        Herramientas reseña = herramientasRepository.findById(id).orElseThrow(()-> new RuntimeException("Reseña no encontrada"));
        return reseña;
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

    public List<String> reseñasPorRutUsuario(String rutUsuario) {
    return herramientasRepository.findAll().stream()
            .filter(nexo -> nexo.getReserva() != null && nexo.getReserva().getUsuario() != null &&
            nexo.getReserva().getUsuario().getRutUsuario().equalsIgnoreCase(rutUsuario))
            .map(nexo -> "Reseña: " + nexo.getReseña() +
            "Puntuación: " + nexo.getPuntuacion() +
            "Usuario: " + nexo.getReserva().getUsuario().getNombreUsuario() + " " +
            nexo.getReserva().getUsuario().getApellidoPaterno() + " " +
            nexo.getReserva().getUsuario().getApellidoMaterno()).toList();
    }

}