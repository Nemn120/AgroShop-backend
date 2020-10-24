package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.ProfileMenuOptionEntity;

public interface IProfileMenuOptionRepository extends JpaRepository<ProfileMenuOptionEntity, Integer>{

}
