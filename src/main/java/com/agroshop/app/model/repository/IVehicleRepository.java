package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.VehicleEntity;

public interface IVehicleRepository extends JpaRepository<VehicleEntity, Integer>{

	@Query("SELECT v FROM VehicleEntity v WHERE  v.driver.id=:id AND v.isDeleted=False ")
	public List<VehicleEntity> getListVehicleByDriver(@Param("id") Integer id);
}
