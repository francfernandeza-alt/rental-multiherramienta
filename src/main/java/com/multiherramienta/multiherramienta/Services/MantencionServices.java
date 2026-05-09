package com.multiherramienta.multiherramienta.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Mantencion;
import com.multiherramienta.multiherramienta.Repository.MantencionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MantencionServices {
@Autowired
    private MantencionRepository mantencionRepository;

    public List<Mantencion> findAll() {
        return mantencionRepository.findAll();
    }

    public Mantencion findById(Integer id) {
        return mantencionRepository.findById(id).orElse(null);
    }

    public Mantencion save(Mantencion mantencion) {
        return mantencionRepository.save(mantencion);
    }

    public void delete(Integer id) {
        mantencionRepository.deleteById(id);
    }
}
