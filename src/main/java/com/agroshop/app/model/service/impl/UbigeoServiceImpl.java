package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.UbigeoEntity;
import com.agroshop.app.model.repository.IUbigeoRepository;
import com.agroshop.app.model.service.IUbigeoService;

@Service
@Repository
public class UbigeoServiceImpl implements IUbigeoService{
	
	@Autowired
	private IUbigeoRepository ubigeoRepo;

	@Override
	public List<UbigeoEntity> getProvinceListByRegionCode(String code) {
		return this.ubigeoRepo.getProvinceListByRegionCode(code);
	}

	@Override
	public List<UbigeoEntity> getDistrictsListByProvinceCodeAndRegionCode(String regionCode, String provinceCode) {
		return this.ubigeoRepo.getDistrictsListByProvinceCodeAndRegionCode(regionCode,provinceCode);
	}

	@Override
	public List<UbigeoEntity> getRegionList() {
		return this.ubigeoRepo.getRegionList();
	}
	

}
