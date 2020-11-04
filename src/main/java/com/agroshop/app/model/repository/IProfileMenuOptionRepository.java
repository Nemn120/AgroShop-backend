package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.ProfileMenuOptionEntity;

public interface IProfileMenuOptionRepository extends JpaRepository<ProfileMenuOptionEntity, Integer>{
	@Query("Select opc from ProfileMenuOptionEntity opc  where opc.profile.idProfile=:profileId")
	List<ProfileMenuOptionEntity> getOptionsByProfileId(@Param("profileId") Integer profileId);
}
