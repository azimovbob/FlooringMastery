/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.ProductDao;
import com.bobazimov.flooringmastery.model.Product;
import java.util.List;

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
        
    }
    
    @Override
    public List<Product> getProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProduct(String productType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
