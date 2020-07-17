/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.State;
import java.util.List;

/**
 *
 * @author irabob
 */
public interface StateDao {
    
    /**
     * 
     * @return 
     */
    public List<State> getStates();
    
    /**
     * 
     * @param state
     * @return State
     */
    public State getState(String state);
    
    /**
     * 
     * @param state 
     */
    public void updateState(State state);
    
    /**
     * 
     * @param state 
     */
    public void createState(State state);
    
    /**
     * 
     * @param state 
     */
    public void deleteState(State state);
}
