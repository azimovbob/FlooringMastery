/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StateDaoImpl implements StateDao {

    private Map<String,State> states;
    final String FILE_STATES_PATH = "Data/Taxes.txt";
    final String DELIMETER = ",";

    public StateDaoImpl() {
        states = new HashMap<>();
    }
    
     public StateDaoImpl(Map<String, State> states) {
        this.states = states;
    }
    
    @Override
    public Map<String, State> getStates() throws OrderPersistenceException{
        readStatesFromFile();
        return states;
    }

    @Override
    public State getState(String state) throws OrderPersistenceException{
        readStatesFromFile();
        return states.get(state);
    }

    @Override
    public State updateState(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State createState(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State deleteState(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private State unmarshalling(String stateAsText){
        String[] statesToken = stateAsText.split(DELIMETER);
        State state = new State();
        state.setStateAbbrivation(statesToken[0]);
        state.setState(statesToken[1]);
        BigDecimal taxRate = new BigDecimal(statesToken[2]);
        state.setTaxRate(taxRate);
        
        return state;
    } 
    
    private void readStatesFromFile() throws OrderPersistenceException{
        
        Scanner scan;
        
        try{
           scan = new Scanner(new BufferedReader(new FileReader(FILE_STATES_PATH))); 
        }catch(FileNotFoundException ex){
            throw new OrderPersistenceException("Could not find the file from data record ", ex);
        }
        
        scan.nextLine();
        String currentLine;
        State currentState;
        while(scan.hasNextLine()){
            currentLine = scan.nextLine();
            currentState = unmarshalling(currentLine);
            states.put(currentState.getStateAbbrivation(), currentState);
        }
        
        scan.close();
    }
    
}
