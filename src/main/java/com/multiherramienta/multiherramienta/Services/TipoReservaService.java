package com.multiherramienta.multiherramienta.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.TipoReserva;
import com.multiherramienta.multiherramienta.Repository.TipoReservaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoReservaService {
@Autowired
    private TipoReservaRepository tipoReservaRepository;

    public List<TipoReserva> findAll() {
        return tipoReservaRepository.findAll();
    }

    public TipoReserva findById(Integer id) {
        return tipoReservaRepository.findById(id).orElse(null);
    }

    public TipoReserva save(TipoReserva tipoReserva) {
        return tipoReservaRepository.save(tipoReserva);
    }

    public void delete(Integer id) {
        tipoReservaRepository.deleteById(id);
    }
}
