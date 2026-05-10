package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.TipoHerramienta;
import com.multiherramienta.multiherramienta.Repository.TipoHerramientaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoHerramientaService {

    @Autowired
    private TipoHerramientaRepository tipoHerramientaRepository;

    public List<TipoHerramienta> obtenerTodos() {
        return tipoHerramientaRepository.findAll();
    }

    public TipoHerramienta buscarPorId(Integer id) {
        return tipoHerramientaRepository.findById(id).orElse(null);
    }

    public TipoHerramienta guardarTipoHerramienta(TipoHerramienta tipoHerramienta) {
        return tipoHerramientaRepository.save(tipoHerramienta);
    }

    public TipoHerramienta actualizarTipoHerramienta(Integer id, TipoHerramienta tipoHerramienta) {
        TipoHerramienta tipoHerramientaEncontrado = tipoHerramientaRepository.findById(id).orElse(null);

        if (tipoHerramientaEncontrado != null) {
            tipoHerramientaEncontrado.setNombreTipoHerramienta(tipoHerramienta.getNombreTipoHerramienta());
            tipoHerramientaEncontrado.setDescripcionTipoHerramienta(tipoHerramienta.getDescripcionTipoHerramienta());
            return tipoHerramientaRepository.save(tipoHerramientaEncontrado);
        }

        return null;
    }

    public String eliminarTipoHerramienta(Integer id) {
        TipoHerramienta tipoHerramienta = tipoHerramientaRepository.findById(id).orElse(null);

        if (tipoHerramienta != null) {
            tipoHerramientaRepository.delete(tipoHerramienta);
            return "Tipo de herramienta eliminado correctamente";
        }

        return "Tipo de herramienta no encontrado";
    }
}