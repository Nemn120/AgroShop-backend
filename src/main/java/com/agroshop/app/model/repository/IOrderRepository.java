package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.OrderEntity;

public interface IOrderRepository extends IOrderCustomRepository, JpaRepository<OrderEntity, Integer> {
	

	@Query("SELECT ord FROM OrderEntity ord WHERE  ord.status=:status AND ord.farmer.id=:farmerId and ord.isDeleted=False ")
	List<OrderEntity> findByStatusAndFarmerId(@Param("status")String status,@Param("farmerId")Integer farmerId);
	
	@Modifying
	@Query("UPDATE OrderEntity set status=:status where id=:id")
	void updateOrderStatus(@Param("id") Integer id, @Param("status") String status);
	
	@Query("Select ord From OrderEntity ord Where ord.status=:status and ord.client.id=:id and ord.isDeleted=False ORDER BY ord.createDate DESC")
	List<OrderEntity> getListOrderByStatusAndClientId(@Param("status") String status, @Param("id") Integer id);
	
	@Modifying
	@Query("UPDATE OrderEntity set photo=:photo where id=:id")
	void updateOrderPhoto(@Param("id") Integer id, @Param("photo") String photo);
	
}
