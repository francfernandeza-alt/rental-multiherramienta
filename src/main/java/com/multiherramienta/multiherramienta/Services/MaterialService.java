package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Material;
import com.multiherramienta.multiherramienta.Repository.MaterialRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Material findById(Integer id) {
        return materialRepository.findById(id).orElse(null);
    }

    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public Material actualizarMaterial(Integer id, Material material) {
        Material materialEncontrado = materialRepository.findById(id).orElse(null);

        if (materialEncontrado != null) {
            materialEncontrado.setNombreMaterial(material.getNombreMaterial());
            materialEncontrado.setDescripcionMaterial(material.getDescripcionMaterial());
            return materialRepository.save(materialEncontrado);
        }

        return null;
    }

    public String delete(Integer id) {
        Material material = materialRepository.findById(id).orElse(null);

        if (material != null) {
            materialRepository.delete(material);
            return "Material eliminado correctamente";
        }

        return "Material no encontrado";
    }
}