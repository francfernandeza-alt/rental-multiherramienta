package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.TipoHerramienta;

@Repository
public interface TipoHerramientaRepository extends JpaRepository<TipoHerramienta, Integer> {

}