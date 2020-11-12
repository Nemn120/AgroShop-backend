package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.DTO.MenuOptionDTO;
import com.agroshop.app.model.entities.MenuOptionEntity;

@Service
public interface IMenuOptionService extends GenericCRUD<MenuOptionEntity, Integer>{
	List<MenuOptionDTO> getListMenuOptionByProfileId(Integer profileId);
}
