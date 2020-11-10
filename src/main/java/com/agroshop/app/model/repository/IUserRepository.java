
package com.agroshop.app.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findOneByUsername(String username);
}


