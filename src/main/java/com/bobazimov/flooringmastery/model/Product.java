/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author irabob
 */
public class Product {
    
    private String productType;
    private BigDecimal costPerSqFt;
    private BigDecimal laborCostPerSqft;
    
    public Product(){}
    public Product(String productType, BigDecimal costPerSqFt, BigDecimal laborCostPerSqft) {}

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public BigDecimal getLaborCostPerSqft() {
        return laborCostPerSqft;
    }

    public void setLaborCostPerSqft(BigDecimal laborCostPerSqft) {
        this.laborCostPerSqft = laborCostPerSqft;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.productType);
        hash = 67 * hash + Objects.hashCode(this.costPerSqFt);
        hash = 67 * hash + Objects.hashCode(this.laborCostPerSqft);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.costPerSqFt, other.costPerSqFt)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSqft, other.laborCostPerSqft)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "productType=" + productType + ", costPerSqFt=" + costPerSqFt + ", laborCostPerSqft=" + laborCostPerSqft + '}';
    }
    
    
}
