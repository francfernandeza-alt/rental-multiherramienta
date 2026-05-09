package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Material;
import com.multiherramienta.multiherramienta.Repository.MaterialRepository;
import com.multiherramienta.multiherramienta.DTO.MaterialDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<MaterialDTO> findAll() {
        return materialRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public MaterialDTO findById(Integer id) {
        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));

        return convertirADTO(material);
    }

    public MaterialDTO save(Material material) {
        Material materialGuardado = materialRepository.save(material);
        return convertirADTO(materialGuardado);
    }

    public MaterialDTO actualizarMaterial(Integer id, Material material) {
        Material materialEncontrado = materialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));

        materialEncontrado.setNombreMaterial(material.getNombreMaterial());
        materialEncontrado.setDescripcionMaterial(material.getDescripcionMaterial());

        Material materialActualizado = materialRepository.save(materialEncontrado);
        return convertirADTO(materialActualizado);
    }

    public String delete(Integer id) {
        Material material = materialRepository.findById(id).orElse(null);

        if (material != null) {
            materialRepository.delete(material);
            return "Material eliminado correctamente";
        }

        return "Material no encontrado";
    }

    private MaterialDTO convertirADTO(Material material) {
        MaterialDTO dto = new MaterialDTO();

        dto.setIdMaterialDTO(material.getIdMaterial());
        dto.setNombreMaterialDTO(material.getNombreMaterial());
        dto.setDescripcionMaterialDTO(material.getDescripcionMaterial());

        return dto;
    }
}