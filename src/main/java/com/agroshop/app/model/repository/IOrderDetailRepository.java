package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.OrderDetailEntity;

public interface IOrderDetailRepository extends IOrderDetailCustomRepository,JpaRepository<OrderDetailEntity, Integer>{

	@Query("SELECT od FROM OrderDetailEntity od WHERE  od.customOrder.id=:orderId and od.isDeleted=False ")
	List<OrderDetailEntity> findByOrderId(@Param("orderId")Integer orderId);
	
//	@Query("Select SUM(od.productSales.weight) FROM OrderDetailEntity od WHERE  od.customOrder.id=:orderId and od.isDeleted=False ")
//	Double TotalWeight(@Param("orderId")Integer orderId);
	
	@Modifying
	@Query("UPDATE OrderDetailEntity set status=:status where customOrder.id=:id")
	void updateOrderDetailStatus(@Param("id") Integer id, @Param("status") String status);
}
