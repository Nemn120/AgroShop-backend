package com.agroshop.app.model.service;

import java.util.List;

import com.agroshop.app.model.entities.UbigeoEntity;

public interface IUbigeoService {
	List<UbigeoEntity> getProvinceListByRegionCode(String code);

	List<UbigeoEntity> getDistrictsListByProvinceCodeAndRegionCode(String regionCode,String provinceCode);
	
	List<UbigeoEntity> getRegionList();

}
