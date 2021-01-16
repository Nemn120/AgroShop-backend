package com.agroshop.app.model.repository.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.agroshop.app.model.DTO.SearchProductSalesByFieldsDTO;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.repository.IProductSalesCustomRepository;
import com.agroshop.app.util.Constants;

public class IProductSalesCustomRepositoryImpl implements IProductSalesCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductSalesEntity> getListProductSalesByFields(SearchProductSalesByFieldsDTO sales, LocalDate date) {
        StringBuffer queryString = new StringBuffer(
                "SELECT ps FROM ProductSalesEntity ps WHERE ps.statusSales=:statusSales ");

        if (sales.getPriceInit() != null && sales.getPriceEnd() != null) {
            queryString.append(" AND ps.price BETWEEN :priceInit AND :priceEnd ");
        }
        if (sales.getType() != null) {
            queryString.append(" AND ps.type=:type ");
        }
        if (sales.getMeasureUnite() != null) {
            queryString.append(" AND ps.measureUnite =:measureUnite ");
        }
        if (sales.getWeightInit() != null && sales.getWeightEnd() != null) {
            queryString.append(" AND ps.weight BETWEEN :weightInit AND :weightEnd ");
        }
        if (sales.getOriginPlace() != null) {
            queryString.append(" AND ps.originPlace.name =: originPlace ");
        }

        Query query = em.createQuery(queryString.toString(), ProductSalesEntity.class);
        query.setParameter("statusSales", Constants.PRODUCT_SALES_STATUS_AVAILABLE);

        if (sales.getPriceInit() != null && sales.getPriceEnd() != null) {
            query.setParameter("priceInit", sales.getPriceInit());
            query.setParameter("priceEnd", sales.getPriceEnd());
        }
        if (sales.getType() != null) {
            query.setParameter("type", sales.getType());
        }
        if (sales.getMeasureUnite() != null) {
            query.setParameter("measureUnite", sales.getMeasureUnite());
        }
        if (sales.getWeightInit() != null && sales.getWeightEnd() != null) {
            query.setParameter("weightInit", sales.getWeightInit());
            query.setParameter("weightEnd", sales.getWeightEnd());
        }
        if (sales.getOriginPlace() != null) {
            query.setParameter("originPlace", sales.getOriginPlace());
        }

        return query.getResultList();
    }

}
