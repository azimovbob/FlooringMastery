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
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public List<Product> getProducts() throws OrderPersistenceException;
    
    /**
     * 
     * @param productType
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public Product getProduct(String productType) throws OrderPersistenceException;
    
    /**
     * 
     * @param product 
     * @return  
     */
    public Product createProduct(Product product);
    
    /**
     * 
     * @param product 
     * @return  
     */
    public Product deleteProduct(Product product);
    
    /**
     * 
     * @param product 
     * @return  
     */
    public Product updateProduct(Product product);
}
