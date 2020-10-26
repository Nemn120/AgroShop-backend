package com.agroshop.app.model.service.impl;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IUserRepository;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;

@Service
public class UserServiceImpl implements IUserService{
	

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);	

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public List<UserEntity> getAll() {
		return userRepo.findAll();
	}

	@Override
	public UserEntity getOneById(Integer id) {
		return userRepo.findById(id).orElse(new UserEntity());
	}

	@Override
	public UserEntity save(UserEntity t) {
		return userRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		userRepo.deleteById(id);
	}

	@Override
	public Boolean acceptUser(Integer bean) {
		try {
			
			UserEntity user = userRepo.getUserCompanyManager(bean, Constants.ADMIN_COMPANY_USER_ROL);
			if(user.getCreateDate()!=null) {
				user.setStatus(Constants.USER_STATUS__ACCEPTED);
				save(user);
				logger.info("Aceptado:" + bean);
				return true;
			}else
				throw new RuntimeException("usuario no encontrado");
		}catch(Exception e) {
			logger.warn("Error usuario no encontrado");
			return false;
		}
	}


}