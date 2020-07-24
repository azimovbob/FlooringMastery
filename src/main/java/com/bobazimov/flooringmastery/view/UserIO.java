/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.view;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author irabob
 */
public interface UserIO {
    
    void print(String msg);
    
    double readDouble(String prompt);
    
    double readDouble(String prompt, double min, double max);
    
    float readFloat(String prompt);
    
    float readFloat(String prompt, float min, float max);
    
    int readInt(String prompt);
    
    int readInt(String prompt, int min, int max);
    
    long readLong(String prompt);
    
    long readLong(String prompt, long min, long max);
    
    String readString(String prompt);
    
    LocalDate readLocalDate(String prompt);
    
    LocalDate readLocalDate(String prompt, LocalDate min);
    
    BigDecimal readBigDecimal(String prompt);
    
    BigDecimal readBigDecimal(String prompt, BigDecimal min);
    
    String readCustomerName(String prompt);
    
    String readUpdatingCustomerName(String prompt); 
    
    BigDecimal readBigDecimalUpdate(String prompt);
}
