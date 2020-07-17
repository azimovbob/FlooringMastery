/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class OrderDaoImpl implements OrderDao {
    
    Map<LocalDate, Map<Integer, Order>> ordersMap = new HashMap<>();
    
    private String FILE_PATH;

    @Override
    public HashMap<Integer, Order> getOrders(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order addOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrder(LocalDate date, int orderNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<LocalDate, HashMap<Integer, Order>> exportAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String marshalling(Order order){
        return null;
    }
    
    private Order unmarshalling(String orderAsText){
        return null;
    }
    
    private void writeToFile(){}
    
    private void readFromFile(){}
}
