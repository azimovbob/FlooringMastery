/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.OrderPersistenceException;
import com.bobazimov.flooringmastery.dao.ProductDao;
import com.bobazimov.flooringmastery.model.Product;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author irabob
 */
public class ProductStubDaoImpl implements ProductDao{
    
    public Product onlyProduct;

    public ProductStubDaoImpl(Product onlyProduct) {
        this.onlyProduct = onlyProduct;
    }

    public ProductStubDaoImpl() {
        onlyProduct = new Product();
        onlyProduct.setCostPerSqFt(new BigDecimal("5.15"));
        onlyProduct.setProductType("Wood");
        onlyProduct.setLaborCostPerSqft(new BigDecimal("4.75"));
    }
    
    @Override
    public Map<String, Product> getProducts() throws OrderPersistenceException{
        Map<String, Product> products = new HashMap<>();
        products.put(onlyProduct.getProductType(), onlyProduct);
        return products;
    }

    @Override
    public Product getProduct(String productType) throws OrderPersistenceException{
        if(productType.equals(onlyProduct.getProductType())){
            return onlyProduct;
        }else{
            return null;
        }
    }

    @Override
    public Product createProduct(Product product) {
        if(onlyProduct.getProductType().equals(product.getProductType())){
            return onlyProduct;
        }else{
            return null;
        }
    }

    @Override
    public Product deleteProduct(Product product) {
        if(onlyProduct.getProductType().equals(product.getProductType())){
            return onlyProduct;
        }else{
            return null;
        }
    }

    @Override
    public Product updateProduct(Product product) {
           if(onlyProduct.getProductType().equals(product.getProductType())){
            return onlyProduct;
        }else{
            return null;
        }
    }
    
}
