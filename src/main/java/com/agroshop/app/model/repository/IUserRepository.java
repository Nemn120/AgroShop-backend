
package com.agroshop.app.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findOneByUsername(String username);
	
	@Query("SELECT user FROM UserEntity user where user.username=:name")
	public List<UserEntity> getUserByUsername(@Param("name") String name);
	
	@Modifying
	@Query("UPDATE UserEntity set photo=:photo where id=:id")
	void updatePhoto(@Param("id") Integer id, @Param("photo") byte[] photo);
}


