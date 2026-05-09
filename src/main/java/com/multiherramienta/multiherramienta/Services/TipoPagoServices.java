package com.multiherramienta.multiherramienta.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.Model.TipoPago;
import com.multiherramienta.multiherramienta.Repository.TipoPagoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoPagoServices {

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    public List<TipoPago> findAll() {
        return tipoPagoRepository.findAll();
    }

    public TipoPago findById(Integer id) {
        return tipoPagoRepository.findById(id).orElse(null);
    }

    public TipoPago save(TipoPago tipoPago) {
        return tipoPagoRepository.save(tipoPago);
    }

    public TipoPago actualizarTipoPago(Integer id, TipoPago tipoPago) {
        TipoPago tipoPagoEncontrado = tipoPagoRepository.findById(id).orElse(null);

        if (tipoPagoEncontrado != null) {
            tipoPagoEncontrado.setMetodoPago(tipoPago.getMetodoPago());
            return tipoPagoRepository.save(tipoPagoEncontrado);
        }

        return null;
    }

    public String delete(Integer id) {
        TipoPago tipoPago = tipoPagoRepository.findById(id).orElse(null);

        if (tipoPago != null) {
            tipoPagoRepository.delete(tipoPago);
            return "Tipo de pago eliminado correctamente";
        }

        return "Tipo de pago no encontrado";
    }
}
