/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.view;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class UserIOImpl implements UserIO {
    
    final private Scanner console = new Scanner(System.in);

    /**
     * 
     *  A very simple method that takes in a message to display on the console 
     * and then waits for a integer answer from the user to return.
     * @param msg 
     */
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * to be returned as the answer to that message.
     *
     * @param prompt
     * @return the answer to the message as double
     */
    @Override
    public double readDouble(String prompt) {
        while(true){
            try{
                return Double.parseDouble(this.readString(prompt));
            }catch(NumberFormatException ex){
                this.print("ERROR: Wrong input, Please try again");
            }
        }
    }

     /**
     *
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an double value as an answer to the message prompt within the min/max range
     */
    @Override
    public double readDouble(String prompt, double min, double max) {
        Double result;
        do{
            result = readDouble(prompt);
        }while(result < min || result > max);
        
        return result;
    }

    @Override
    public float readFloat(String prompt) {
        while(true){
            try{
                return Float.parseFloat(this.readString(prompt));
            }catch(NumberFormatException ex){
                this.print("Error: Wrong input, Please try again");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do{
            result = readFloat(prompt);
        }while(result < min || result >max);
        
        return result;
      
    }

    @Override
    public int readInt(String prompt) {
        while(true){
            try{
                return Integer.parseInt(this.readString(prompt));
            }catch(NumberFormatException ex){
                this.print("Error: Input error, Please try again");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do{
            result = readInt(prompt);
        }while(result < min || result >max);
        
        return result;
    }

    @Override
    public long readLong(String prompt) {
        while(true){
            try{
                return Long.parseLong(this.readString(prompt));
            }catch(NumberFormatException ex){
                this.print("Error: Input error, Please try again");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result;
        do{
            result = readLong(prompt);
        }while(result < min || result > max);
        return result;        
    }

     /**
     *
     * A simple method that takes in a message to display on the console, 
     * and then waits for an answer from the user to return.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as string
     */
    @Override
    public String readString(String msgPrompt) {
        System.out.println(msgPrompt);
        return console.nextLine();
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        while(true){
            try{
                return LocalDate.parse(this.readString(prompt), DateTimeFormatter.ofPattern("MMddyyyy"));
            }catch(DateTimeException ex){
                this.print("Input Error, Please try again" + "Throwing error " + ex.getMessage());
            }
        }
    }

    @Override
    public LocalDate readLocalDate(String prompt, LocalDate min) {
       LocalDate ld;
       do{
           ld = readLocalDate(prompt);
       }while(ld.isBefore(min));
       return ld;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        while(true){
            try{
                return new BigDecimal(this.readString(prompt));  
            }catch(NumberFormatException ex){
                this.print("Wrong input, Please try again");
            }
        }
    }
    
    @Override
    public BigDecimal readBigDecimalUpdate(String prompt) {
        while(true){
            try{
                String number = this.readString(prompt);
                if(number.isBlank() || number.isEmpty()){
                    return null;
                }
                return new BigDecimal(number);  
            }catch(NumberFormatException ex){
                this.print("Wrong input. Please try again");
            }
        }
    }

    
    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min) {
        BigDecimal result;
        do{
            result = readBigDecimal(prompt);
        }while(result.compareTo(min) < 0);
        return result;
    }

    @Override
    public String readCustomerName(String prompt) {
        String regex = "^[a-zA-Z0-9,. ]+";
        String name;
        boolean hasError;
        do{
            hasError= false;
            name = this.readString(prompt);
            if(!name.matches(regex) || name.isBlank()){
                hasError = true;
                this.print("Customer name cannot be blank and should contain following characters [a-z0-9,.]");
            }
        }while(hasError);
        
        return name;
    }
    
    @Override
    public String readUpdatingCustomerName(String prompt) {
        String regex = "^[a-zA-Z0-9,. ]*";
        String name;
        boolean hasError;
        do{
            hasError= false;
            name = this.readString(prompt);
            if(!name.matches(regex)){
                hasError = true;
                this.print("Customer name cannot be blank and should contain following characters [a-z0-9,.]");
            }
        }while(hasError);
        
        return name;
    }
    
    
    
}
