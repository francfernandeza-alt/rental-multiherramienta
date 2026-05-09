package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Herramienta;
import com.multiherramienta.multiherramienta.Model.Mantencion;
import com.multiherramienta.multiherramienta.Model.Mantenciones;
import com.multiherramienta.multiherramienta.Repository.HerramientaRepository;
import com.multiherramienta.multiherramienta.Repository.MantencionRepository;
import com.multiherramienta.multiherramienta.Repository.MantencionesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MantencionesService {

    @Autowired
    private MantencionesRepository mantencionesRepository;

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Autowired
    private MantencionRepository mantencionRepository;

    public List<Mantenciones> findAll() {
        return mantencionesRepository.findAll();
    }

    public Mantenciones findById(Integer id) {
        return mantencionesRepository.findById(id).orElse(null);
    }

    public Mantenciones save(Mantenciones mantenciones) {
        if (mantenciones == null || mantenciones.getHerramienta() == null || mantenciones.getMantencion() == null) {
            return null;
        }

        Integer idHerramienta = mantenciones.getHerramienta().getIdHerramienta();
        Integer idMantencion = mantenciones.getMantencion().getIdMantencion();

        if (idHerramienta == null || idMantencion == null) {
            return null;
        }

        Herramienta herramienta = herramientaRepository.findById(idHerramienta).orElse(null);
        Mantencion mantencion = mantencionRepository.findById(idMantencion).orElse(null);

        if (herramienta == null || mantencion == null) {
            return null;
        }

        mantenciones.setHerramienta(herramienta);
        mantenciones.setMantencion(mantencion);

        return mantencionesRepository.save(mantenciones);
    }

    public Mantenciones actualizarMantenciones(Integer id, Mantenciones mantenciones) {
        Mantenciones mantencionesEncontrada = mantencionesRepository.findById(id).orElse(null);

        if (mantencionesEncontrada == null) {
            return null;
        }

        Mantenciones mantencionesValidada = save(mantenciones);

        if (mantencionesValidada == null) {
            return null;
        }

        mantencionesEncontrada.setHerramienta(mantencionesValidada.getHerramienta());
        mantencionesEncontrada.setMantencion(mantencionesValidada.getMantencion());

        return mantencionesRepository.save(mantencionesEncontrada);
    }

    public String delete(Integer id) {
        Mantenciones mantenciones = mantencionesRepository.findById(id).orElse(null);

        if (mantenciones != null) {
            mantencionesRepository.delete(mantenciones);
            return "Relación mantención-herramienta eliminada correctamente";
        }

        return "Relación mantención-herramienta no encontrada";
    }

}
