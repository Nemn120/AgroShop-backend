package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.MenuOptionEntity;
import com.agroshop.app.model.repository.IMenuOptionRepository;
import com.agroshop.app.model.service.IMenuOptionService;

@Service
public class MenuOptionServiceImpl implements IMenuOptionService{

	@Autowired
	private IMenuOptionRepository menuOptionRepo;
	
	@Override
	public List<MenuOptionEntity> getAll() {
		return menuOptionRepo.findAll();
	}

	@Override
	public MenuOptionEntity getOneById(Integer id) {
		return menuOptionRepo.getOne(id);
	}

	@Override
	public MenuOptionEntity save(MenuOptionEntity t) {
		return menuOptionRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		menuOptionRepo.deleteById(id);
	}

}
