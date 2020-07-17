/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.view;

import com.bobazimov.flooringmastery.model.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author irabob
 */
public class OrderView {
    
    
    UserIO io;
    
    public OrderView(UserIO io){
    
    }
    
    public int printMenuAndGetSelection(){
        return 0;
    }
    
    public Order getOrderInfo(){
        Order newOrder = new Order();
        
        return null;
    }
    
    public LocalDate getOrderDate(){
        return null;
    }
    
    public String getCustomerName(){
        return null;
    }
    
    public int getOrderNumber(){
        return 0;
    }
    
    public BigDecimal getArea(){
        return null;
    }
    
    public String getSate(){
        return null;
    }

    public String getProductType(){
        return null;
    }
    
    public void listOrdersByDate(List<Order> orders){
        
    }
    
    public void displayOrder(Order order){
    }
    
    public void orderRemovedBanner(Order order){
    }
    
    public void orderAddedBanner(Order order){
    
    }
    
    public void orderUpdatedBanner(Order order){
    
    }
    
    public void displayErrorMessage(String message){
    
    }
    
    public void displayExitMessage(){
    
    }
    
    public void dislayOrdersByDateBanner(){
    
    }
    
    
    
    
}
