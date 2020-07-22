/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ProductDaoImpl implements ProductDao {

    public Map<String, Product> products;
    public static final String DELIMETER = ",";
    public String PRODUCT_FILE_PATH = "Data/Products.txt";
    
    public ProductDaoImpl(){
        products = new HashMap<>();
    }
    
    public ProductDaoImpl(Map<String, Product> products){
        this.products = products;
    }
    
    private Product unmarshalling(String productAsText){
        String[] productToken = productAsText.split(DELIMETER);
        Product product = new Product();
        product.setProductType(productToken[0]);
        BigDecimal productCostPerSqFt = new BigDecimal(productToken[1]);
        product.setCostPerSqFt(productCostPerSqFt);
        BigDecimal laborCostPerSqFt = new BigDecimal(productToken[2]);
        product.setLaborCostPerSqft(laborCostPerSqFt);

        return product;
        
    }
    
    private void readFromFile() throws OrderPersistenceException{
        Scanner scan;
      
          try{
            scan = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE_PATH)));
        }catch(FileNotFoundException ex){
            throw new OrderPersistenceException("Could not find the file in data memomry", ex);
        }
        
        scan.nextLine();
        String currentLine;
        Product currentProduct;
        while(scan.hasNextLine()){
            currentLine = scan.nextLine();
            currentProduct = unmarshalling(currentLine);
            
            products.put(currentProduct.getProductType(), currentProduct);
        }
        
        scan.close();
    }
    
    @Override
    public List<Product> getProducts() throws OrderPersistenceException{
        readFromFile();
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProduct(String productType) throws OrderPersistenceException {
        readFromFile();
        return products.get(productType);
    }

    @Override
    public Product createProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
