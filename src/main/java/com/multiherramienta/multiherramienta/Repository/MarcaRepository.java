package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository <Marca, Integer> {

}
