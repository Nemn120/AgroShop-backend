package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

}
