/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.controller;

import com.bobazimov.flooringmastery.dao.OrderPersistenceException;
import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import com.bobazimov.flooringmastery.service.OrderDataValidationException;
import com.bobazimov.flooringmastery.service.OrderService;
import com.bobazimov.flooringmastery.service.OrderValidationException;
import com.bobazimov.flooringmastery.service.ValidateStateAndProductException;
import com.bobazimov.flooringmastery.view.OrderView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author irabob
 */
public class OrderController {
    
    OrderView view;
    OrderService service;
    
    public OrderController(OrderView view, OrderService service){
        this.view = view;
        this.service = service;
    }
    
    public void run(){
        boolean keepGoing = true;
        int choice = 0;
        while(keepGoing){
           
           choice = view.printMenuAndGetSelection();
                switch(choice){
                    case 1: displayOrders();
                    break;
                    case 2: addOrder();
                    break;
                    case 3: editOrder();
                    break;
                    case 4: removeOrder();
                    break;
                    case 5: exportAllData();
                    break;
                    case 6: System.exit(0);
                    break;
                    default: break;
                }
                        
               }
        
    }
    
    private void addOrder(){
        
        view.displayAddOrderBanner();
        boolean hasError = false;
        do{
            try{
                LocalDate date = view.getNewOrderDate();
                String customerName = view.getCustomerName();
                String stateAbbrivation = view.getSate();
                State state = service.getState(stateAbbrivation);
                List<Product> products = service.getProducts();
                view.displayProducts(products);
                String productType = view.getProductType();
                Product product = service.getProduct(productType);
                BigDecimal area = view.getArea();
                Order order = view.getOrderInfo(product, customerName, state, date, area);
                Order calculatedOrder = service.createAndCalculateTotal(order);
                view.displayConfirmingOrderMessage();
                view.displayOrder(calculatedOrder);
                String confirm = view.getConfirmation();
                if(confirm.equals("Y") || confirm.equals("y")){
                    service.addOrder(calculatedOrder);
                    view.displayOrderCreated();
                }
                
            }catch(OrderPersistenceException | OrderDataValidationException | ValidateStateAndProductException ex){
                hasError = true;
                view.displayErrorMessage(ex.getMessage());
            }
        }while(hasError);
    }
    
    private void displayOrders(){
        try{
        view.dislayOrdersByDateBanner();
        LocalDate date = view.getOrderDate();
        List<Order> orders = service.getOrders(date);
        view.listOrdersByDate(orders);
        view.displayCompleteMessage();
        }catch(OrderPersistenceException | OrderValidationException ex){
            view.displayErrorMessage(ex.getMessage());
        }
    }
        
    
    private void removeOrder(){
        try{
        view.orderRemoveBanner();
        LocalDate date = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        Order removingOrder = service.getOrder(date, orderNumber);
        String confirm = view.getConfirmation();
        if(confirm.equals("Y") || confirm.equals("y")){
            service.removeOrder(removingOrder);
            view.displayRemovedOrderMsg();
        }
        }catch(OrderPersistenceException | OrderValidationException ex){
            view.displayErrorMessage(ex.getMessage());
        }
    }
    
    private void editOrder(){
        try{
            LocalDate date = view.getOrderDate();
            int orderNumber = view.getOrderNumber();
            Order updatingOrder = service.getOrder(date, orderNumber);
            String customerName = view.updatingCustomerName(updatingOrder);
            BigDecimal area = view.getUpdatingArea(updatingOrder);
            String stateAbbrivation = view.updatingState(updatingOrder);
            State state = service.getState(stateAbbrivation);
            String productType = view.updatingProduct(updatingOrder);
            Product product = service.getProduct(productType);
            Order newOrder = view.updateOrder(updatingOrder, state, product, customerName, area);
            Order calculatedOrder = service.createAndCalculateTotal(newOrder);
            view.displayOrder(calculatedOrder);
            String confirm = view.getConfirmation();
            if(confirm.equals("Y") || confirm.equals("y")){
                service.updateOrder(calculatedOrder);
                view.displayUpdatedMessage();
            }
        }catch(OrderPersistenceException | OrderValidationException | 
               ValidateStateAndProductException | OrderDataValidationException ex){
            view.displayErrorMessage(ex.getMessage());
        }
        
    }
    
    private void exportAllData(){
        
        try{
            Map<LocalDate, Map<Integer, Order>> exportingData = service.getAllOrders();
            service.exportAllData(exportingData);
        }catch(OrderPersistenceException ex){
            view.displayErrorMessage(ex.getMessage());
        }
        view.displayExportedDataCompleteMsg();
    }
    
    
}
