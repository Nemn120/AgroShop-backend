package com.agroshop.app.model.repository.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.beanutils.PropertyUtils;


@Aspect
@Component
public class RepositoryAudiTracking {
	
	private static final Logger log = LogManager.getLogger();
	
	@Pointcut("execution(* org.springframework.data.repository.CrudRepository+.save(..))" + "&& args(entity,..)" )
	public void saveMethodExecution(Object entity) {
	}
	@Around(value="saveMethodExecution(entity)")
	public Object aroundSaveMethodExecution(ProceedingJoinPoint joinPoint, Object entity) throws Throwable {
		
		Object ob = null;
		try {
			if(PropertyUtils.getProperty(entity, "createDate") == null) {
				PropertyUtils.setProperty(entity, "createDate",LocalDateTime.now());
				PropertyUtils.setProperty(entity, "isDeleted",false);
				// .. active status
			}
			
			PropertyUtils.setProperty(entity, "updateDate",LocalDateTime.now());
			
			
			
			/*if(PropertyUtils.getProperty(entity, "organizationId") == null) {
				PropertyUtils.setProperty(entity, "organizationId",((UserPrincipal)principal).getOrganizationId());
			
			}	
			if(PropertyUtils.getProperty(entity, "userCreateId") == null && !"anonymousUser".equals(principal)) {
				PropertyUtils.setProperty(entity, "userCreateId",((UserPrincipal)principal).getId());
			}*/
			
			
			ob=joinPoint.proceed();
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		return ob;
	}
	

}
