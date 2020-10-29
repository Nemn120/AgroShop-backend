package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agroshop.app.model.entities.VehicleEntity;

public interface IVehicleRepository extends JpaRepository<VehicleEntity, Integer>{

}
