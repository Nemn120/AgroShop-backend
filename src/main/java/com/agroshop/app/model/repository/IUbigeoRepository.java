package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.UbigeoEntity;

public interface IUbigeoRepository extends JpaRepository<UbigeoEntity, Integer>{

	@Query("Select a FROM UbigeoEntity a where a.codigoDistrito='00' and a.codigoDepartamento=:code and a.codigoProvincia!='00'")
	List<UbigeoEntity> getProvinceListByRegionCode(@Param("code") String code);
	
	@Query("Select a FROM UbigeoEntity a where a.codigoProvincia=:provinceCode and a.codigoDepartamento=:regionCode and a.codigoDistrito!='00' ORDER BY a.idUbigeo")
	List<UbigeoEntity> getDistrictsListByProvinceCodeAndRegionCode(@Param("regionCode")String regionCode,@Param("provinceCode")String provinceCode);
	
	@Query("Select a FROM UbigeoEntity a where a.codigoProvincia='00' and a.codigoDistrito='00' and a.codigoDepartamento!='99' ORDER BY a.idUbigeo")
	List<UbigeoEntity> getRegionList();
}
