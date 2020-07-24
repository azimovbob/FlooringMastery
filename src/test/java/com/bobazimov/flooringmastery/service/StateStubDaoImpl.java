/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.StateDao;
import com.bobazimov.flooringmastery.model.State;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author irabob
 */
public class StateStubDaoImpl implements StateDao{

    public State onlyState;

    public StateStubDaoImpl() {
        onlyState = new State();
        onlyState.setState("Washington");
        onlyState.setStateAbbrivation("WA");
        onlyState.setTaxRate(new BigDecimal("9.25"));
    }
    
    public StateStubDaoImpl(State onlyState) {
        this.onlyState = onlyState;
    }
    
    @Override
    public Map<String, State> getStates() {
        Map<String, State> stateMap = new HashMap<>();
        stateMap.put(onlyState.getStateAbbrivation(), onlyState);
        return stateMap;
    }

    @Override
    public State getState(String state) {
        if(onlyState.getStateAbbrivation().equals(state)){
            return onlyState;
        }
        else{
            return null;
        }
    }

    @Override
    public State updateState(State state) {
        if(onlyState.getStateAbbrivation().equals(state.getStateAbbrivation())){
            return onlyState;
        }
        else{
            return null;
        }
    }

    @Override
    public State createState(State state) {
        if(onlyState.getStateAbbrivation().equals(state.getStateAbbrivation())){
            return onlyState;
        }
        else{
            return null;
        }
    }

    @Override
    public State deleteState(State state) {
        if(onlyState.getStateAbbrivation().equals(state.getStateAbbrivation())){
            return onlyState;
        }
        else{
            return null;
        }
    }
    
}
