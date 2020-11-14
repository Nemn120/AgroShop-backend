package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.entities.VehicleEntity;

public interface IProductSalesRepository extends JpaRepository<ProductSalesEntity, Integer> {
	// List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales);
	
	@Query("SELECT p FROM ProductSalesEntity p INNER JOIN p.product pro where p.status=:status and p.statusSales=:statusSales and UPPER(pro.name) LIKE CONCAT('%',UPPER(:searchProduct),'%') order by p.farmerNumber asc")
	List<ProductSalesEntity> getListSearchProductSales(@Param("searchProduct")String searchProduct, @Param("status") String status, @Param("statusSales") String statusSales);
	
	@Query("SELECT p FROM ProductSalesEntity p WHERE  p.farmerNumber=:id AND p.isDeleted=False ")
	public List<ProductSalesEntity> getListProductSalesByFarmer(@Param("id") Integer id);
	
	@Query("SELECT p FROM ProductSalesEntity p WHERE  p.farmerNumber=:id AND p.isDeleted=False AND p.status=:status ")
	public List<ProductSalesEntity> getListProductSalesByFarmerAndStatus(@Param("id") Integer id, @Param("status") String status);
	
	ProductSalesEntity findByIdAndStatusAndStatusSales(Integer id, String status,String statusSales);
	
	@Query("SELECT p FROM ProductSalesEntity p WHERE  p.farmerNumber=:id AND p.product.id=:idp ")
	public List<ProductSalesEntity> getListProductSalesByProductId(@Param("id") Integer id, @Param("idp") Integer idp);
}
