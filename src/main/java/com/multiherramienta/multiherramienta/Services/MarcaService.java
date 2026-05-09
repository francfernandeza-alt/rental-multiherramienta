package com.multiherramienta.multiherramienta.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.DTO.MarcaDTO;
import com.multiherramienta.multiherramienta.DTO.UsuarioDTO;
import com.multiherramienta.multiherramienta.Model.Marca;
import com.multiherramienta.multiherramienta.Model.Reserva;
import com.multiherramienta.multiherramienta.Model.Usuario;
import com.multiherramienta.multiherramienta.Repository.MarcaRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class MarcaService {
    @Autowired
    public MarcaRepository marcaRepository;

    public List<MarcaDTO> obtenerTodos() {
        return marcaRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    public MarcaDTO buscarporId(Integer id) {
        Marca marca = marcaRepository.findById(id).orElseThrow(()-> new RuntimeException("Marca no encontrada"));
        return convertirADTO(marca);
    }

    public String eliminar(Integer id) {
        try {
            Marca marca = marcaRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca con Id " + id + " no existe."));
            marcaRepository.delete(marca);
            return "Marca '" + marca.getNombreMarca() + " ha sido eliminada.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Marca guardarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca actualizarMarca(Integer id,Marca marca){
        Marca mar = marcaRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca no existe"));
        if(marca.getNombreMarca() != null){
            mar.setNombreMarca(marca.getNombreMarca());
        }
        if(marca.getDescripcionMarca() != null){
            mar.setDescripcionMarca(marca.getDescripcionMarca());
        }
        return marcaRepository.save(mar);
    }

    public MarcaDTO convertirADTO(Marca marca) {
        MarcaDTO dto = new MarcaDTO();
        dto.setIdMarcaDTO(marca.getIdMarca());
        return dto;
    }
}
