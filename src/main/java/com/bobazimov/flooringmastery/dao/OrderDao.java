/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author irabob
 */
public interface OrderDao {
    
    /**
     * 
     * @param date
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    List<Order> getOrders(LocalDate date) throws OrderPersistenceException;
    
    /**
     * 
     * @param order
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public Order addOrder(Order order) throws OrderPersistenceException;
    
    /**
     * 
     * @param order 
     * @return  
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public Order updateOrder(Order order) throws OrderPersistenceException;
    
    /**
     * 
     * @param order
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public Order removeOrder(Order order) throws OrderPersistenceException;
    
    /**
     * 
     * @param date
     * @param orderNumber
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public Order getOrder(LocalDate date, int orderNumber) throws OrderPersistenceException;
    
    /**
     * 
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public Map<LocalDate, Map<Integer, Order>> exportAllData() throws OrderPersistenceException;
    
    /**
     * 
     * @return
     * @throws OrderPersistenceException 
     */
    public List<Map<Integer, Order>> getOrderNumbers() throws OrderPersistenceException;
}
