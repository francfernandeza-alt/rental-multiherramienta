package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.TipoHerramienta;
import com.multiherramienta.multiherramienta.Repository.TipoHerramientaRepository;
import com.multiherramienta.multiherramienta.DTO.TipoHerramientaDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoHerramientaService {

    @Autowired
    private TipoHerramientaRepository tipoHerramientaRepository;

    public List<TipoHerramienta> findAll() {
        return tipoHerramientaRepository.findAll();
    }

    public TipoHerramientaDTO findById(Integer id) {
        TipoHerramienta tipoHerramienta = tipoHerramientaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de herramienta no encontrado"));

        return convertirADTO(tipoHerramienta);
    }

    public TipoHerramienta save(TipoHerramienta tipoHerramienta) {
        return tipoHerramientaRepository.save(tipoHerramienta);
    }

    public TipoHerramientaDTO actualizarTipoHerramienta(Integer id, TipoHerramienta tipoHerramienta) {
        TipoHerramienta tipoHerramientaEncontrado = tipoHerramientaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de herramienta no encontrado"));

        tipoHerramientaEncontrado.setNombreTipoHerramienta(tipoHerramienta.getNombreTipoHerramienta());
        tipoHerramientaEncontrado.setDescripcionTipoHerramienta(tipoHerramienta.getDescripcionTipoHerramienta());

        TipoHerramienta tipoHerramientaActualizado = tipoHerramientaRepository.save(tipoHerramientaEncontrado);
        return convertirADTO(tipoHerramientaActualizado);
    }

    public String delete(Integer id) {
        TipoHerramienta tipoHerramienta = tipoHerramientaRepository.findById(id).orElse(null);

        if (tipoHerramienta != null) {
            tipoHerramientaRepository.delete(tipoHerramienta);
            return "Tipo de herramienta eliminado correctamente";
        }

        return "Tipo de herramienta no encontrado";
    }

    private TipoHerramientaDTO convertirADTO(TipoHerramienta tipoHerramienta) {
        TipoHerramientaDTO dto = new TipoHerramientaDTO();

        dto.setIdTipoHerramientaDTO(tipoHerramienta.getIdTipoHerramienta());
        dto.setNombreTipoHerramientaDTO(tipoHerramienta.getNombreTipoHerramienta());
        dto.setDescripcionTipoHerramientaDTO(tipoHerramienta.getDescripcionTipoHerramienta());

        return dto;
    }
}