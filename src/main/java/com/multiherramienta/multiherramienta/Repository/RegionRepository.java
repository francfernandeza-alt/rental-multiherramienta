package com.multiherramienta.multiherramienta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiherramienta.multiherramienta.Model.Region;

@Repository
public interface RegionRepository extends JpaRepository <Region, Integer> {

}
