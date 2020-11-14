package com.agroshop.app.model.repository.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IUserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.beanutils.PropertyUtils;


@Aspect
@Component
public class RepositoryAudiTracking {
	
	private static final Logger log = LogManager.getLogger();
	@Autowired
	private IUserRepository userRepo;
	
	@Pointcut("execution(* org.springframework.data.repository.CrudRepository+.save(..))" + "&& args(entity,..)" )
	public void saveMethodExecution(Object entity) {
	}
	@Around(value="saveMethodExecution(entity)")
	public Object aroundSaveMethodExecution(ProceedingJoinPoint joinPoint, Object entity) throws Throwable {
		Object ob = null;
		try {
			if( PropertyUtils.getProperty(entity, "id") == null) {
				PropertyUtils.setProperty(entity, "createDate",LocalDateTime.now());
				PropertyUtils.setProperty(entity, "isDeleted",false);
			}
			
			PropertyUtils.setProperty(entity, "updateDate",LocalDateTime.now());
			ob=joinPoint.proceed();
		}catch(Exception e) {
			log.error(e);
			throw new Throwable("Eror al realizar AOP");
			
		}
		return ob;
	}
	

}
