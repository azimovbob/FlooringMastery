/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.OrderPersistenceException;
import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author irabob
 */
public interface OrderService {
    
    /**
     * 
     * @param order
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    Order addOrder(Order order) throws OrderPersistenceException;
    
    /**
     * 
     * @param order 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    void removeOrder(Order order) throws OrderPersistenceException;
    
    /**
     * 
     * @param order 
     * @return  
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    Order updateOrder(Order order) throws OrderPersistenceException;
    
    /**
     * 
     * @param date
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     * @throws com.bobazimov.flooringmastery.service.OrderValidationException 
     */
    List<Order> getOrders(LocalDate date) throws OrderPersistenceException, OrderValidationException;
    
    /**
     * 
     * @param date
     * @param orderNumber
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     * @throws com.bobazimov.flooringmastery.service.OrderValidationException 
     */
    Order getOrder(LocalDate date, int orderNumber) throws OrderPersistenceException, OrderValidationException;
    
    /**
     * 
     * @param allOrders 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    void exportAllData(Map<LocalDate, Map<Integer, Order>> allOrders) throws OrderPersistenceException;
    
    /**
     * 
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    List<Product> getProducts() throws OrderPersistenceException;
    
    /**
     * 
     * @param productType
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    Product getProduct(String productType) throws OrderPersistenceException;
    
    /**
     * 
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    List<State> getStates() throws OrderPersistenceException;
    
    /**
     * 
     * @param stateName
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    State getState(String stateName) throws OrderPersistenceException;
    
    /**
     * 
     * @param order
     * @return
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException
     * @throws ValidateStateAndProductException 
     * @throws com.bobazimov.flooringmastery.service.OrderDataValidationException 
     */
    Order createAndCalculateTotal(Order order)throws OrderPersistenceException, ValidateStateAndProductException, OrderDataValidationException ;
    
    /**
     * 
     * @return
     * @throws OrderPersistenceException 
     */
    Map<LocalDate, Map<Integer, Order>> getAllOrders() throws OrderPersistenceException;
}
