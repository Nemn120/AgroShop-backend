package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.ClientEntity;

public interface IClientRepository extends JpaRepository<ClientEntity, Integer>{

}
