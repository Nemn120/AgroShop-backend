package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.CategoryProductEntity;
import com.agroshop.app.model.entities.VehicleEntity;

public interface ICategoryProductRepository extends JpaRepository<CategoryProductEntity, Integer> {

	@Query("SELECT v FROM CategoryProductEntity v WHERE  v.userCreateId=:id AND v.isDeleted=False ")
	public List<CategoryProductEntity> getListCategory(@Param("id") Integer id);
}
