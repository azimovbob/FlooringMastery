/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.OrderDao;
import com.bobazimov.flooringmastery.dao.ProductDao;
import com.bobazimov.flooringmastery.dao.StateDao;
import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


public class OrderServiceImpl implements OrderService {

    OrderDao orderDao;
    ProductDao productDao;
    StateDao stateDao;
    
    private void validateCustomerName(String customerName){
    
    }
    
    private void validateDate(LocalDate date){
    
    }
    
    private void validateOrderNumber(int orderNumber){
    
    }
    
    private void validateState(String stateName){
    
    }
    
    private void validateArea(BigDecimal area){
    
    }
    
    private int generateOrderNumber(List<Integer> orderNumbers){
        return 0;
    }
     
    private BigDecimal calculateTotalPrice(BigDecimal area, Product productType, State state){
        return null;
    }
    
    @Override
    public Order addOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getOrders(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrder(LocalDate date, int orderNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<State> getStates() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getState(String stateName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ExportAllData(HashMap<LocalDate, HashMap<Integer, Order>> allOrders) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order createOrder(String customerValidation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
