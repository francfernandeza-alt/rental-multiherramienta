package com.multiherramienta.multiherramienta.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.DTO.ReservaDTO;
import com.multiherramienta.multiherramienta.DTO.UsuarioDTO;
import com.multiherramienta.multiherramienta.Model.Herramienta;
import com.multiherramienta.multiherramienta.Model.Herramientas;
import com.multiherramienta.multiherramienta.Model.Reserva;
import com.multiherramienta.multiherramienta.Model.Usuario;
import com.multiherramienta.multiherramienta.Repository.ReservaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReservaService {
    @Autowired
    public ReservaRepository reservaRepository;

    public List<ReservaDTO> obtenerTodos() {
        return reservaRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    public ReservaDTO buscarpornumReserva(Integer numeroReserva) {
        Reserva reserva = reservaRepository.findById(numeroReserva).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
        return convertirADTO(reserva);
    }

    public String eliminar(Integer numeroReserva) {
        try {
            Reserva reserva = reservaRepository.findById(numeroReserva).orElseThrow(() -> new RuntimeException("Reserva N°  " + numeroReserva + " no existe."));
            reservaRepository.delete(reserva);
            return "La reserva N° '" + reserva.getNumeroReserva() + " ha sido eliminada.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva actualizarReserva(Integer numeroReserva, Reserva reserva){
        Reserva res = reservaRepository.findById(numeroReserva).orElseThrow(() -> new RuntimeException("Reserva no existe"));
        if(reserva.getNumeroReserva() != null){
            res.setNumeroReserva(reserva.getNumeroReserva());
        }
        if(reserva.getFechaInicio() != null){
            res.setFechaInicio(reserva.getFechaInicio());
        }
        if(reserva.getFechaFin() != null){
            res.setFechaFin(reserva.getFechaFin());
        }
        if(reserva.getEstadoReserva() != null){
            res.setEstadoReserva(reserva.getEstadoReserva());
        }
        return reservaRepository.save(res);
    }

    public ReservaDTO convertirADTO (Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();
        dto.setNumeroReservaDTO(reserva.getNumeroReserva());
        dto.setFechaInicioDTO(reserva.getFechaInicio());
        dto.setFechaFinDTO(reserva.getFechaFin());
        dto.setEstadoReservaDTO(reserva.getEstadoReserva());

        if(reserva.getUsuario() != null) {
            dto.setRutUsuarioDTO(reserva.getUsuario().getRutUsuario());
            dto.setNombreCompletoUsuarioDTO(reserva.getUsuario().getNombreUsuario() + " " +
                reserva.getUsuario().getApellidoPaterno() + " " + reserva.getUsuario().getApellidoMaterno());
        }else{
            dto.setNombreCompletoUsuarioDTO("No, no se llama.");
        }

        List<String> nombresHerramientas = new ArrayList<>();
        if(reserva.getHerramientas() != null) {
            for(Herramientas nexo : reserva.getHerramientas()){
                if(nexo.getHerramienta()!= null){
                    nombresHerramientas.add(nexo.getHerramienta().getNombreHerramienta());
                }
            }
        }
        dto.setNombreHerramientas(nombresHerramientas);
        return dto;
    }
        
}


