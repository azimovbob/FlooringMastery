/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Product;
import java.util.List;

/**
 *
 * @author irabob
 */
public interface ProductDao {
    
    /**
     * 
     * @return 
     */
    public List<Product> getProducts();
    
    /**
     * 
     * @param productType
     * @return 
     */
    public Product getProduct(String productType);
    
    /**
     * 
     * @param product 
     */
    public void createProduct(Product product);
    
    /**
     * 
     * @param product 
     */
    public void deleteProduct(Product product);
    
    /**
     * 
     * @param product 
     */
    public void updateProduct(Product product);
}
