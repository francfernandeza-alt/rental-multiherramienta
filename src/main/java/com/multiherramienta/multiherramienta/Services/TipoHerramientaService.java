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

    public List<TipoHerramienta> findAll() {
        return tipoHerramientaRepository.findAll();
    }

    public TipoHerramienta findById(Integer id) {
        return tipoHerramientaRepository.findById(id).orElse(null);
    }

    public TipoHerramienta save(TipoHerramienta tipoHerramienta) {
        return tipoHerramientaRepository.save(tipoHerramienta);
    }

    public void delete(Integer id) {
        tipoHerramientaRepository.deleteById(id);
    }
}