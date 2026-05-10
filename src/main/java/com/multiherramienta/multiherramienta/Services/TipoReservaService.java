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

    public List<TipoReserva> obtenerTodos() {
        return tipoReservaRepository.findAll();
    }

    public TipoReserva buscarPorId(Integer id) {
        return tipoReservaRepository.findById(id).orElse(null);
    }

    public TipoReserva guardarTipoReserva(TipoReserva tipoReserva) {
        return tipoReservaRepository.save(tipoReserva);
    }

    public TipoReserva actualizarTipoReserva(Integer id, TipoReserva tipoReserva) {
        TipoReserva tipoReservaEncontrado = tipoReservaRepository.findById(id).orElse(null);

        if (tipoReservaEncontrado != null) {
            tipoReservaEncontrado.setNombreTipoReserva(tipoReserva.getNombreTipoReserva());
            return tipoReservaRepository.save(tipoReservaEncontrado);
        }

        return null;
    }

    public String eliminar(Integer id) {
        TipoReserva tipoReserva = tipoReservaRepository.findById(id).orElse(null);

        if (tipoReserva != null) {
            tipoReservaRepository.delete(tipoReserva);
            return "Tipo de reserva eliminado correctamente";
        }

        return "Tipo de reserva no encontrado";
    }
}
