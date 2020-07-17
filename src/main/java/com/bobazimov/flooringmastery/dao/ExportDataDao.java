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
public interface ExportDataDao {
    
    /**
     * 
     * @param allOrders 
     */
    public void getAllData(HashMap<LocalDate, HashMap<Integer, Order>> allOrders);
    
    /**
     * 
     * @param order 
     */
    public void deleteOrder(Order order);
    
    /**
     * 
     * @param order 
     */
    public void updateOrder(Order order);
    
    /**
     * 
     * @param order 
     */
    public void createOrder(Order order);
    
    /**
     * 
     * @param order 
     */
    public void getOrder(Order order);
    
    
}
