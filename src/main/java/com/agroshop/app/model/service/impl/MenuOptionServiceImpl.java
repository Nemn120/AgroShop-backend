package com.agroshop.app.model.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.controller.rest.FarmerController;
import com.agroshop.app.model.DTO.MenuOptionDTO;
import com.agroshop.app.model.entities.MenuOptionEntity;
import com.agroshop.app.model.entities.ParentMenuOptionEntity;
import com.agroshop.app.model.repository.IMenuOptionRepository;
import com.agroshop.app.model.repository.IParentMenuOptionRepository;
import com.agroshop.app.model.service.IMenuOptionService;

@Service
public class MenuOptionServiceImpl implements IMenuOptionService{

	@Autowired
	private IMenuOptionRepository menuOptionRepo;
	
	@Autowired
	private IParentMenuOptionRepository parentRepo;
	
	private static final Logger logger = LogManager.getLogger(MenuOptionServiceImpl.class);

	@Override
	public List<MenuOptionEntity> getAll() {
		return menuOptionRepo.findAll();
	}

	@Override
	public MenuOptionEntity getOneById(Integer id) {
		return menuOptionRepo.findById(id).orElse(new MenuOptionEntity());
	}

	@Override
	public MenuOptionEntity save(MenuOptionEntity t) {
		return menuOptionRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		menuOptionRepo.deleteById(id);
	}

	@Override
	public List<MenuOptionDTO> getListMenuOptionByProfileId(Integer profileId) {
		List<MenuOptionDTO> menus = new ArrayList<MenuOptionDTO>();
		
		menuOptionRepo.getOptionsByProfileId(profileId).forEach(x -> {	
			logger.info(String.valueOf(x[2]));
			MenuOptionDTO m = new MenuOptionDTO();
			m.setFaIcon(String.valueOf(x[1]));
			m.setLabel(String.valueOf(x[2]));
			m.setOrderNumber(Integer.parseInt(String.valueOf(x[3])));
			m.setLink(String.valueOf(x[4]));
			
			Integer idParent=Integer.parseInt(String.valueOf(x[5]));
			
		
			List<MenuOptionDTO> menuSelects=menus.stream().filter(data ->data.getId() ==idParent)
					.collect(Collectors.toList());
		
			if(menuSelects.size()>0) {
				menuSelects.get(0).getItems().add(m);
				logger.info(m.toString());
			}
			else {
				ParentMenuOptionEntity parent = parentRepo.findById(idParent).get();
				if(parent != null) {
					MenuOptionDTO mParent= new MenuOptionDTO(parent.getId(),
							parent.getNameMenu(),parent.getIconMenu(),parent.getOrderNumber());
					mParent.setItems(new ArrayList<MenuOptionDTO>());
					mParent.getItems().add(m);
					menus.add(mParent);
				}
				logger.info(parent.toString());
				
			}
		});
		return menus;
	}

}
