/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.State;
import java.util.Map;

/**
 *
 * @author irabob
 */
public interface StateDao {
    
    /**
     * 
     * @return 
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException 
     */
    public Map<String, State> getStates() throws OrderPersistenceException;
    
    /**
     * 
     * @param state
     * @return State
     * @throws com.bobazimov.flooringmastery.dao.OrderPersistenceException
     */
    public State getState(String state) throws OrderPersistenceException;
    
    /**
     * 
     * @param state 
     * @return  
     */
    public State updateState(State state);
    
    /**
     * 
     * @param state 
     * @return  
     */
    public State createState(State state);
    
    /**
     * 
     * @param state 
     * @return  
     */
    public State deleteState(State state);
}
