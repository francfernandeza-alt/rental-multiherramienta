package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.Herramienta;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Integer>  {

}