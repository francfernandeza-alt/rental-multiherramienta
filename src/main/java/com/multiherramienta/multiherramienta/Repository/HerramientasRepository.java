package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.Herramientas;

@Repository
public interface HerramientasRepository extends JpaRepository <Herramientas, Integer> {

}
