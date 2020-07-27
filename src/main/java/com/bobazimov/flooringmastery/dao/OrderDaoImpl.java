/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class OrderDaoImpl implements OrderDao {
    
    private Map<LocalDate, Map<Integer, Order>> outer = new HashMap<>();
    final private String DELIMETER = ",";
    
    private String FILE_PATH;
    
    public OrderDaoImpl(){
        FILE_PATH = "Orders/";
    }
    
    public OrderDaoImpl(String FILE_PATH){
        this.FILE_PATH = FILE_PATH;
    }
    
    @Override
    public List<Order> getOrders(LocalDate date) throws OrderPersistenceException{
        readFromFile();
        return new ArrayList<>(outer.get(date).values());
    }
    
    

    @Override
    public Order addOrder(Order order) throws OrderPersistenceException{
        readFromFile();
        Order newOrder;
        if(outer.containsKey(order.getDate())){
            outer.get(order.getDate()).put(order.getOrderNumber(), order);
            newOrder = outer.get(order.getDate()).get(order.getOrderNumber());
        }else{
            Map<Integer, Order> innerMap = new HashMap<>();
            innerMap.put(order.getOrderNumber(), order);
            outer.put(order.getDate(), innerMap);
            newOrder = outer.get(order.getDate()).get(order.getOrderNumber());
        }
        writeToFile();
        return newOrder;
    }

    @Override
    public Order updateOrder(Order order) throws OrderPersistenceException{
        readFromFile();
        outer.get(order.getDate()).replace(order.getOrderNumber(), order);
        Order updatedOrder = outer.get(order.getDate()).get(order.getOrderNumber());
        writeToFile();
        return updatedOrder;
                //outer.get(order.getDate()).get(order.getOrderNumber());
    }

    @Override
    public Order removeOrder(Order order) throws OrderPersistenceException{
        readFromFile();
        Order removedOrder = outer.get(order.getDate()).remove(order.getOrderNumber());
        writeToFile();
        return removedOrder;
    }

    @Override
    public Order getOrder(LocalDate date, int orderNumber) throws OrderPersistenceException{
        readFromFile();
        return outer.get(date).get(orderNumber);
    }

    @Override
    public Map<LocalDate, Map<Integer, Order>> exportAllData() throws OrderPersistenceException{
        readFromFile();
        return outer;
    }
    
    private String marshalling(Order order){
        //OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total
        if(order.getCustomerName().contains(DELIMETER)){
            String replace = order.getCustomerName().replace(DELIMETER, ";");
            order.setCustomerName(replace);
        }
        String orderAsText = order.getOrderNumber() + DELIMETER + order.getCustomerName() + DELIMETER + order.getState().getStateAbbrivation()
                            + DELIMETER + order.getState().getTaxRate() + DELIMETER + order.getProduct().getProductType() + DELIMETER
                            + order.getArea() + DELIMETER + order.getProduct().getCostPerSqFt() + DELIMETER + order.getProduct().getLaborCostPerSqft() 
                            + DELIMETER + order.getTotalProductCost() + DELIMETER + order.getTotalLaborCost() + DELIMETER + order.getTotalTax() 
                            + DELIMETER + order.getTotal();
        return orderAsText;
    }
    
    private Order unmarshalling(String orderAsText){
        
        String[] orderTokens = orderAsText.split(DELIMETER);
        Order order = new Order();
        order.setOrderNumber(Integer.parseInt(orderTokens[0]));
        if(orderTokens[1].contains(";")){
            orderTokens[1] = orderTokens[1].replace(";", DELIMETER);
        }
        order.setCustomerName(orderTokens[1]);
        State state = new State();
        state.setStateAbbrivation(orderTokens[2]);
        BigDecimal taxRate = new BigDecimal(orderTokens[3]);
        state.setTaxRate(taxRate);
        Product product = new Product();
        product.setProductType(orderTokens[4]);
        BigDecimal area = new BigDecimal(orderTokens[5]);
        order.setArea(area);
        BigDecimal costPerSqFt = new BigDecimal(orderTokens[6]);
        BigDecimal laborCostPerSqFt = new BigDecimal(orderTokens[7]);
        product.setCostPerSqFt(costPerSqFt);
        product.setLaborCostPerSqft(laborCostPerSqFt);
        order.setProduct(product);
        order.setState(state);
        BigDecimal materialCost = new BigDecimal(orderTokens[8]);
        BigDecimal laborCost = new BigDecimal(orderTokens[9]);
        BigDecimal tax = new BigDecimal(orderTokens[10]);
        BigDecimal total = new BigDecimal(orderTokens[11]);
        order.setTotalProductCost(materialCost);
        order.setTotalLaborCost(laborCost);
        order.setTotalTax(tax);
        order.setTotal(total);
        return order;
    }
    
    private void writeToFile() throws OrderPersistenceException{
        PrintWriter out;
        String dvdAsText;
        for(Map.Entry<LocalDate, Map<Integer, Order>> orderEntry: outer.entrySet()){
            
            LocalDate ld = orderEntry.getKey();
            String date = ld.format(DateTimeFormatter.ofPattern("MMddyyyy"));
            try{
            out = new PrintWriter(new FileWriter(FILE_PATH + "Orders_" + date + ".txt"));
            }catch(IOException ex){
            throw new OrderPersistenceException("Cannot save the data");
            }
            out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
            for(Map.Entry<Integer, Order> currentOrder: orderEntry.getValue().entrySet()){
                dvdAsText = marshalling(currentOrder.getValue());
                out.println(dvdAsText);
                out.flush();
            }
            out.close();
        
        }
    }
    
    private void readFromFile() throws OrderPersistenceException{
        Scanner scan;
        File folder = new File(FILE_PATH);
        File[] files = folder.listFiles();
        
        for(File file: files){
            try{
                scan = new Scanner(new FileReader(file.getAbsolutePath()));
            }catch(FileNotFoundException ex){
                throw new OrderPersistenceException("Could not find the file from data records");
            }
            
            String date = file.getName().substring(7, 15);
            //DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMyyyy");
            LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
            //System.out.println(ld);
            scan.nextLine();
            if(!scan.hasNextLine()){
                    file.delete();
                }
            String currentLine;
            Order currentOrder;
            Map<Integer, Order> inner = new HashMap<>();
            while(scan.hasNextLine()){
                currentLine = scan.nextLine();
                currentOrder = unmarshalling(currentLine);
                currentOrder.setDate(ld);
                inner.put(currentOrder.getOrderNumber(), currentOrder); 
            }
            scan.close();
            
            outer.put(ld, inner);
        }
        
    }
    
    @Override
    public List<Map<Integer, Order>> getOrderNumbers() throws OrderPersistenceException{
        readFromFile();
        return new ArrayList<>(outer.values());
    }

    @Override
    public List<LocalDate> orderDate() throws OrderPersistenceException {
        readFromFile();
        return new ArrayList<>(outer.keySet());
    }
    
}