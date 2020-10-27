package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.ProductSalesEntity;

public interface IProductSalesRepository extends JpaRepository<ProductSalesEntity, Integer> {
	// List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales);
	
	@Query("SELECT p FROM ProductSalesEntity p INNER JOIN p.product pro where p.status=:status and UPPER(pro.name) LIKE CONCAT('%',UPPER(:searchProduct),'%') order by p.organizationId asc")
	List<ProductSalesEntity> getListSearchProductSales(@Param("searchProduct")String searchProduct, @Param("status") String status);
	
}
