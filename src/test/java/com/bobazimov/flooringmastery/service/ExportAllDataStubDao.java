/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.ExportDataDao;
import com.bobazimov.flooringmastery.model.Order;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author irabob
 */
public class ExportAllDataStubDao implements ExportDataDao {
    
    ExportDataDao testExportDao;
    
    

    @Override
    public void getAllData(HashMap<LocalDate, HashMap<Integer, Order>> allOrders) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
