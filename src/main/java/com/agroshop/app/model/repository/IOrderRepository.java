package com.agroshop.app.model.repository;

import java.time.LocalDateTime;
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


	@Query("Select SUM(ord.total) FROM OrderEntity ord WHERE ord.farmer.id=:id and ord.createDate BETWEEN :initDate AND :finalDate")
	Double getSales(@Param("id") Integer id, @Param("initDate") LocalDateTime initDate, @Param("finalDate") LocalDateTime finalDate);
	
	@Query("Select SUM(ord.quantity) FROM OrderEntity ord WHERE ord.farmer.id=:id and ord.createDate BETWEEN :initDate AND :finalDate")
	Integer getQuantity(@Param("id") Integer id, @Param("initDate") LocalDateTime initDate, @Param("finalDate") LocalDateTime finalDate);

}
