/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.State;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author irabob
 */
public class StateDaoImplTest {
    
    //Map<String, State> states;
    
    StateDao dao;
    
    public StateDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
       dao = new StateDaoImpl();
    }
    
    @AfterEach
    public void tearDown() {
    }
  
    @Test
    public void testGetState() throws Exception{
        
        
        State state = new State();
        
        state.setState("Texas");
        state.setStateAbbrivation("TX");
        BigDecimal taxRate = new BigDecimal("4.45");
        state.setTaxRate(taxRate);
        
        State state1 = dao.getState("TX");
        
        assertEquals(state1, state, "objects must be equal");
        assertNotNull(state1, "It should not be null");
    }
    
    @Test void testGetStates(){
    
    }
    
}
