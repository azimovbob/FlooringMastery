/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author irabob
 */
public class ProductDaoImplTest {
    
    //Map<String, Product> products;
    
    ProductDao dao;
    
    public ProductDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao = new ProductDaoImpl();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test 
    public void testGetProduct() throws OrderPersistenceException{
        //Arrange
        Product product = new Product();
        product.setProductType("Carpet");
        BigDecimal productCost = new BigDecimal("2.25");
        BigDecimal laborCost = new BigDecimal("2.10");
        product.setCostPerSqFt(productCost);
        product.setLaborCostPerSqft(laborCost);
        
        //Action 
        Product product1 = dao.getProduct("Carpet");
        //Assert
        assertEquals(product, product1, "This two product objects must be eqaul");
        assertNotNull(product1, "It must be not null");
    
    }
    
    @Test
        public void testGetProducts()  throws OrderPersistenceException{
            
           List<Product> testProductList;
           Product product = new Product();
           product.setProductType("Carpet");
           BigDecimal productCost = new BigDecimal("2.25");
           BigDecimal laborCost = new BigDecimal("2.10");
           product.setCostPerSqFt(productCost);
           product.setLaborCostPerSqft(laborCost);
           
           testProductList = new ArrayList<>(dao.getProducts().values());
           
           assertNotNull(testProductList, "it must be not null");
           assertTrue(testProductList.contains(product));
        }
}
