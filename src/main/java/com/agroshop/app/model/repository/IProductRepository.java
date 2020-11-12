package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;

public interface IProductRepository  extends JpaRepository<ProductEntity, Integer> {
	List<ProductEntity> findByCategoryId(Integer categoryId);
	
	@Query("SELECT p FROM ProductEntity p WHERE  p.userCreateId=:id AND p.isDeleted=False ")
	public List<ProductEntity> getListProductByFarmer(@Param("id") Integer id);
	
	@Modifying
	@Query("UPDATE ProductEntity set photo=:photo where id=:id")
	void updatePhoto(@Param("id") Integer id, @Param("photo") byte[] photo);
}
