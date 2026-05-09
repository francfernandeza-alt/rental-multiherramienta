package com.multiherramienta.multiherramienta.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.Mantenciones;
import com.multiherramienta.multiherramienta.Repository.MantencionesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MantencionesService {
 @Autowired
    private MantencionesRepository mantencionesRepository;

    public List<Mantenciones> findAll() {
        return mantencionesRepository.findAll();
    }

    public Mantenciones findById(Integer id) {
        return mantencionesRepository.findById(id).orElse(null);
    }

    public Mantenciones save(Mantenciones mantenciones) {
        return mantencionesRepository.save(mantenciones);
    }

    public void delete(Integer id) {
        mantencionesRepository.deleteById(id);
    }
}
