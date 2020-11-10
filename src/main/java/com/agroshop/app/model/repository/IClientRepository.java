package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.FarmerEntity;

public interface IClientRepository extends JpaRepository<ClientEntity, Integer>{
	@Query("SELECT client FROM ClientEntity client INNER JOIN  client.user u WHERE u.username=:username")
	public ClientEntity getUserByUsername(@Param("username") String username);
}
