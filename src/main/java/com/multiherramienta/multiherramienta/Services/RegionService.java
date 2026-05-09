package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Region;
import com.multiherramienta.multiherramienta.Repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> obtenerTodos() {
        return regionRepository.findAll();
    }

    public Region buscarporId(Integer numeroRegion) {
        Region region = regionRepository.findById(numeroRegion).orElseThrow(()-> new RuntimeException("Region no encontrada"));
        return region;
    }

    public String eliminar(Integer numeroRegion) {
        try {
            Region region = regionRepository.findById(numeroRegion).orElseThrow(() -> new RuntimeException("La region " + numeroRegion + " no existe."));
            regionRepository.delete(region);
            return "La region '" + region.getNombreRegion() + " ha sido eliminada.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Region guardarRegion(Region region) {
        return regionRepository.save(region);
    }

    public Region actualizarRegion(Integer numeroRegion,Region region){
        Region reg = regionRepository.findById(numeroRegion).orElseThrow(() -> new RuntimeException("Region no existe"));
        if(region.getNumeroRegion() != null){
            reg.setNumeroRegion(region.getNumeroRegion());
        }
        if(region.getNombreRegion() != null){
            reg.setNombreRegion(region.getNombreRegion());
        }
        return regionRepository.save(reg);
    }

}
