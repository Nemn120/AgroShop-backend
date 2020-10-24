package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.ProfileEntity;

public interface IProfileRepository extends JpaRepository<ProfileEntity, Integer>{

}
