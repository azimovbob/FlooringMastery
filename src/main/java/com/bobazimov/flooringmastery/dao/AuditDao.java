/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

/**
 *
 * @author irabob
 */
public interface AuditDao {
    
    /**
     * 
     * @param message 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public void writeAuditEntry(String message) throws OrderPersistenceException;
}
