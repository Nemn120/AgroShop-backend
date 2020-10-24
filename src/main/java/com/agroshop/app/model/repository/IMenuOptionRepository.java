package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.MenuOptionEntity;

public interface IMenuOptionRepository extends JpaRepository<MenuOptionEntity, Integer>{

}
