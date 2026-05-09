package com.multiherramienta.multiherramienta.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Direccion;
import com.multiherramienta.multiherramienta.Repository.DireccionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DireccionService {
@Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    public Direccion findById(Integer id) {
        return direccionRepository.findById(id).orElse(null);
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public void delete(Integer id) {
        direccionRepository.deleteById(id);
    }
}
