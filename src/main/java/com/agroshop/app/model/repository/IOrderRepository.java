package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.OrderEntity;

public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {
	

	@Query("SELECT ord FROM OrderEntity ord WHERE  ord.status=:status AND ord.farmer.id=:farmerId and ord.isDeleted=False ")
	List<OrderEntity> findByStatusAndFarmerId(@Param("status")String status,@Param("farmerId")Integer farmerId);

}
