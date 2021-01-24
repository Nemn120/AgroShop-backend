package com.agroshop.app.model.DTO;

public class SearchProductSalesByFieldsDTO {

    private Integer priceInit;
    private Integer priceEnd;
    private String type;
    private String measureUnite;
    private Integer weightInit;
    private Integer weightEnd;
    private String statusSales;
    private String originPlace;

    /**
     * @return the priceInit
     */
    public Integer getPriceInit() {
        return priceInit;
    }

    /**
     * @param priceInit the priceInit to set
     */
    public void setPriceInit(Integer priceInit) {
        this.priceInit = priceInit;
    }

    /**
     * @return the priceEnd
     */
    public Integer getPriceEnd() {
        return priceEnd;
    }

    /**
     * @param priceEnd the priceEnd to set
     */
    public void setPriceEnd(Integer priceEnd) {
        this.priceEnd = priceEnd;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the measureUnite
     */
    public String getMeasureUnite() {
        return measureUnite;
    }

    /**
     * @param measureUnite the measureUnite to set
     */
    public void setMeasureUnite(String measureUnite) {
        this.measureUnite = measureUnite;
    }

    /**
     * @return the weightInit
     */
    public Integer getWeightInit() {
        return weightInit;
    }

    /**
     * @param weightInit the weightInit to set
     */
    public void setWeightInit(Integer weightInit) {
        this.weightInit = weightInit;
    }

    /**
     * @return the weightEnd
     */
    public Integer getWeightEnd() {
        return weightEnd;
    }

    /**
     * @param weightEnd the weightEnd to set
     */
    public void setWeightEnd(Integer weightEnd) {
        this.weightEnd = weightEnd;
    }

    /**
     * @return the statusSales
     */
    public String getStatusSales() {
        return statusSales;
    }

    /**
     * @param statusSales the statusSales to set
     */
    public void setStatusSales(String statusSales) {
        this.statusSales = statusSales;
    }

    /**
     * @return the originPlace
     */
    public String getOriginPlace() {
        return originPlace;
    }

    /**
     * @param originPlace the originPlace to set
     */
    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

}