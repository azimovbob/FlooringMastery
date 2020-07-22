/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

/**
 *
 * @author irabob
 */
public class OrderValidationException extends Exception{
    
   public  OrderValidationException(String message){
       super(message);
   }
   
   public OrderValidationException(String message, Throwable ex){
       super(message, ex);
   }
}
