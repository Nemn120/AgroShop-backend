package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.MenuOptionEntity;

public interface IMenuOptionRepository extends JpaRepository<MenuOptionEntity, Integer>{
	@Query(value="Select distinct m.*  from profile_menu_option pro  inner join  menu_option m  on pro.menu_id=m.id_menu where pro.profile_id=:profileId"
			,nativeQuery=true)
	List<Object[]> getOptionsByProfileId(@Param("profileId") Integer profileId);
}
