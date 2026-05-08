package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository <Reserva, Integer> {

}
