/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author irabob
 */
public interface OrderService {
    
    /**
     * 
     * @param order
     * @return 
     */
    Order addOrder(Order order);
    
    /**
     * 
     * @param order 
     */
    void removeOrder(Order order);
    
    /**
     * 
     * @param order 
     */
    void updateOrder(Order order);
    
    /**
     * 
     * @param date
     * @return 
     */
    List<Order> getOrders(LocalDate date);
    
    /**
     * 
     * @param date
     * @param orderNumber
     * @return 
     */
    Order getOrder(LocalDate date, int orderNumber);
    
    /**
     * 
     * @param allOrders 
     */
    void ExportAllData(HashMap<LocalDate, HashMap<Integer, Order>> allOrders);
    
    /**
     * 
     * @param customerValidation
     * @return 
     */
    Order createOrder(String customerValidation);
    
    /**
     * 
     * @return 
     */
    List<Product> getProducts();
    
    /**
     * 
     * @param productType
     * @return 
     */
    Product getProduct(String productType);
    
    /**
     * 
     * @return 
     */
    List<State> getStates();
    
    /**
     * 
     * @param stateName
     * @return 
     */
    State getState(String stateName);
    
}
