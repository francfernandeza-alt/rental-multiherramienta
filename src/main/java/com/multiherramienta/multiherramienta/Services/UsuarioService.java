package com.multiherramienta.multiherramienta.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiherramienta.multiherramienta.DTO.UsuarioDTO;
import com.multiherramienta.multiherramienta.Model.Reserva;
import com.multiherramienta.multiherramienta.Model.Usuario;
import com.multiherramienta.multiherramienta.Repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obtenerTodos() {
        return usuarioRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    public UsuarioDTO buscarporId(String rut) {
        Usuario usuario = usuarioRepository.findById(rut).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        return convertirADTO(usuario);
    }

    public String eliminar(String id) {
        try {
            Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario con rut " + id + " no existe."));
            usuarioRepository.delete(usuario);
            return "El usuario '" + usuario.getNombreUsuario() + " ha sido eliminado.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(String id,Usuario usuario){
        Usuario us = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no existe"));
        if(usuario.getNombreUsuario() != null){
            us.setNombreUsuario(usuario.getNombreUsuario());
        }
        if(usuario.getApellidoPaterno() != null){
            us.setApellidoPatern(usuario.getApellidoPaterno());
        }
        if(usuario.getApellidoMaterno() != null){
            us.setApellidoMaterno(usuario.getApellidoMaterno());
        }
        if(usuario.getTipoUsuario() != null){
            us.setTipoUsuario(usuario.getTipoUsuario());
        }
        if(usuario.getEmailUsuario() != null){
            us.setEmailUsuario(usuario.getEmailUsuario());
        }
        if(usuario.getContraseñaUsuario() != null){
            us.setContraseñaUsuario(usuario.getContraseñaUsuario());
        }
        return usuarioRepository.save(us);
    }

    public UsuarioDTO convertirADTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setRutUsuarioDTO(usuario.getRutUsuario());
        dto.setNombreUsuarioDTO(usuario.getNombreUsuario());
        dto.setApellidoPaternoDTO(usuario.getApellidoPaterno());
        dto.setEmailUsuarioDTO(usuario.getEmailUsuario());

        if(usuario.getDireccion() != null) {
            String direccionCompleta= usuario.getDireccion().getCalle() + " " + usuario.getDireccion().getNumeracion();
            dto.setDireccionUsuarioDTO(direccionCompleta);
        }else{
            dto.setDireccionUsuarioDTO("Siempreviva 742");
        }

        List<Integer> numeroReservas = new ArrayList<>();
        if(usuario.getReservas() != null) {
            for(Reserva nexo : usuario.getReservas()){
                numeroReservas.add(nexo.getNumeroReserva());
            }
        }
        dto.setNumeroReservas(numeroReservas);

        return dto;

    }
    
}
