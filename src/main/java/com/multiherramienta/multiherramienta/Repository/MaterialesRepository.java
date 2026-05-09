package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.Materiales;

@Repository
public interface MaterialesRepository extends JpaRepository <Materiales, Integer>{

}
