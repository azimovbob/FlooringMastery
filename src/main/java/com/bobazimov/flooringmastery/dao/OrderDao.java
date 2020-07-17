/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Order;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author irabob
 */
public interface OrderDao {
    
    /**
     * 
     * @param date
     * @return 
     */
    public HashMap<Integer, Order> getOrders(LocalDate date);
    
    /**
     * 
     * @param order
     * @return 
     */
    public Order addOrder(Order order);
    
    /**
     * 
     * @param order 
     */
    public void updateOrder(Order order);
    
    /**
     * 
     * @param order
     * @return 
     */
    public Order removeOrder(Order order);
    
    /**
     * 
     * @param date
     * @param orderNumber
     * @return 
     */
    public Order getOrder(LocalDate date, int orderNumber);
    
    /**
     * 
     * @return 
     */
    public HashMap<LocalDate, HashMap<Integer, Order>> exportAllData();
}
