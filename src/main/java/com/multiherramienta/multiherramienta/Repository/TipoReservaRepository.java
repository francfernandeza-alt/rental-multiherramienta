package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.TipoReserva;
@Repository
public interface TipoReservaRepository extends JpaRepository<TipoReserva, Integer> {


}
