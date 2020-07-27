/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.view;

import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author irabob
 */
public class OrderView {
    
    
    private UserIO io;
    
    public OrderView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection(){
        
        io.print("*******************************");
        io.print("* <<Flooring Program");
        io.print("*1. Display Ordrers");
        io.print("*2. Add an Order");
        io.print("*3. Edit an Order");
        io.print("*4. Remove an Order");
        io.print("*5. Export All Data");
        io.print("*6. Quit");
        io.print("*");
        io.print("*******************************");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public Order getOrderInfo(Product product, String customerName, State state, LocalDate date, BigDecimal area){
       
        Order newOrder = new Order();
        newOrder.setDate(date);
        newOrder.setCustomerName(customerName);
        newOrder.setProduct(product);
        newOrder.setState(state);
        newOrder.setArea(area);
        
        return newOrder;
    }
    
    public LocalDate getOrderDate(){
        return io.readLocalDate("Enter date <MMddyyyy>");
    }
    
    public LocalDate getNewOrderDate(){
        return io.readLocalDate("Enter date for new Order <MMddyyyy>", LocalDate.now());
    }
    
    public String getCustomerName(){
        return io.readCustomerName("Enter customerName");
    }
    
    public int getOrderNumber(){
        return io.readInt("Enter ordernumber");
    }
    
    public BigDecimal getArea(){
        return io.readBigDecimal("Enter the area", new BigDecimal("100"));
    }
    
    public String getSate(){
        return io.readString("Enter the state ex(NY)").toUpperCase();
    }

    public String getProductType(){
        return io.readString("Choose product from the list");
    }
    
    public void listOrdersByDate(List<Order> orders){
        for(Order currentOrder: orders){
            this.displayOrderWithOrderNumber(currentOrder);
        }
    }
    
    public void displayOrder(Order order){
        
        io.print("NAME: " + order.getCustomerName());
        io.print("DATE: " + order.getDate().format(DateTimeFormatter.ofPattern("MMddyyyy")));
        io.print("STATE: " + order.getState().getStateAbbrivation());
        io.print("PRODUCT: " + order.getProduct().getProductType());
        io.print("AREA: " + order.getArea().toString());
        io.print("LABOR COST: " + order.getTotalProductCost().toString());
        io.print("PRODUCT COST: " + order.getTotalLaborCost().toString());
        io.print("TAX: " + order.getTotalTax().toString());
        io.print("TOTAL: " + order.getTotal().toString()); 
    }
    
    public void orderRemoveBanner(){
        io.print("************************");
        io.print("* REMOVE ORDER");
        io.print("************************");
    }
    
    public void displayErrorMessage(String message){
        io.print(message);
    }
    
    public void displayExitMessage(){
    
    }
    
    public void dislayOrdersByDateBanner(){
        io.print("************************");
        io.print("* DISPLAY ORDER");
        io.print("************************");
    }
    
    public String  getConfirmation(){
         return io.readString("Are you comfirming the Order (Y/N)");
    }
    
    public void displayAddOrderBanner(){
        io.print("************************");
        io.print("* ADD ORDER");
        io.print("************************");   
    }
    
    public void displayOrderCreated(){
        io.readString("Order add successfully, Please hit enter to continue");
    }
    
    public void displayRemovedOrderMsg(){
        io.readString("Order removed successfully. Please hit enter to continue");
    }
    
    public void displayCompleteMessage(){
        io.readString("Please hit enter to continue");
    }
    
    public void displayProducts(List<Product> products){
        io.print("Product list");
        for(Product currentProduct: products){
            io.print(currentProduct.toString());
        }
    }
    
    public void displayConfirmingOrderMessage(){
        io.print("Please check the order info before proceeding");
    }
    
    public void displayExportedDataCompleteMsg(){
        io.readString("Data exported successfully, Please hit enter to continue");
    }
    
    public BigDecimal getUpdatingArea(Order order){
        BigDecimal area = io.readBigDecimalUpdate("Enter the area (" + order.getArea().toString() + "):");
        if(area == null){
            return order.getArea();
        }else if(area.compareTo(new BigDecimal("100")) < 0){
            io.print("Wrong input. Please try again");
        }else{
            return area;
        }
        return this.getArea();
    }
    
    public String updatingCustomerName(Order order){
        String customerName = io.readUpdatingCustomerName("Enter customer name (" + order.getCustomerName() + "):");
        if(customerName.isBlank() || customerName.isEmpty()){
            return order.getCustomerName();
        }
        return customerName;
    }
    
    public String updatingState(Order order){
        String state = io.readString("Enter state (" + order.getState().getStateAbbrivation() + "):");
        if(state.isBlank()){
            return order.getState().getStateAbbrivation();
        }
        return state;
    }
    
    public String updatingProduct(Order order){
        String product = io.readString("Enter product (" + order.getProduct().getProductType() + "):");
        if(product.isBlank()){
            return order.getProduct().getProductType();
        }
        return product;
    }
    
    public Order updateOrder(Order order, State state, Product product, String customerName, BigDecimal area){
        Order updatingOrder = order;
        updatingOrder.setProduct(product);
        updatingOrder.setCustomerName(customerName);
        updatingOrder.setArea(area);
        updatingOrder.setState(state);
        
        return updatingOrder;
    }
    
    public void displayUpdatedMessage(){
        io.readString("Order updated successfully. Please hit enter to continue");
    }
    
    public void displayUpdateOrderBanner(){
        io.print("************************");
        io.print("* UPDATE ORDER");
        io.print("************************");   
    }
    
    public void displayOrderWithOrderNumber(Order order){
        io.print("NAME: " + order.getCustomerName());
        io.print("ORDER#: " + Integer.toString(order.getOrderNumber()));
        io.print("DATE: " + order.getDate().format(DateTimeFormatter.ofPattern("MMddyyyy")));
        io.print("STATE: " + order.getState().getStateAbbrivation());
        io.print("PRODUCT: " + order.getProduct().getProductType());
        io.print("AREA: " + order.getArea().toString());
        io.print("LABOR COST: " + order.getTotalProductCost().toString());
        io.print("PRODUCT COST: " + order.getTotalLaborCost().toString());
        io.print("TAX: " + order.getTotalTax().toString());
        io.print("TOTAL: " + order.getTotal().toString()); 
    }
}


