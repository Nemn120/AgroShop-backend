
package com.agroshop.app.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findOneByUsername(String username);
	
	UserEntity findOneByOrganizationId(Integer organizationId);
	
	@Query("SELECT u FROM UserEntity u WHERE u.organizationId=:organizationId  AND u.profile.idProfile=:idProfile")
	public UserEntity getUserCompanyManager(@Param("organizationId") Integer orgId, @Param("idProfile") Integer idprofile);
}


