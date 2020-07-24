/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.OrderDao;
import com.bobazimov.flooringmastery.dao.OrderPersistenceException;
import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author irabob
 */
public class OrderStubDaoImpl implements OrderDao{

    public Order onlyOrder;

    public OrderStubDaoImpl() {
        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        onlyOrder = new Order();
        onlyOrder.setOrderNumber(2);
        onlyOrder.setCustomerName("Doctor Who");
        State state = new State();
        state.setStateAbbrivation("WA");
        BigDecimal taxRate = new BigDecimal("9.25");
        state.setTaxRate(taxRate);
        Product product = new Product();
        product.setProductType("Wood");
        BigDecimal area = new BigDecimal("243.00");
        onlyOrder.setArea(area);
        BigDecimal costPerSqFt = new BigDecimal("5.15");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.75");
        product.setCostPerSqFt(costPerSqFt);
        product.setLaborCostPerSqft(laborCostPerSqFt);
        onlyOrder.setProduct(product);
        onlyOrder.setState(state);
        BigDecimal materialCost = new BigDecimal("1251.45");
        BigDecimal laborCost = new BigDecimal("1154.25");
        BigDecimal tax = new BigDecimal("222.52");
        BigDecimal total = new BigDecimal("2628.22");
        onlyOrder.setTotalProductCost(materialCost);
        onlyOrder.setTotalLaborCost(laborCost);
        onlyOrder.setTotalTax(tax);
        onlyOrder.setTotal(total);
        onlyOrder.setDate(ld);
    }

    public OrderStubDaoImpl(Order onlyOrder) {
        this.onlyOrder = onlyOrder;
    }
    
    @Override
    public List<Order> getOrders(LocalDate date) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(onlyOrder);
        return orderList; 
    }

    @Override
    public Order addOrder(Order order) {
        if(onlyOrder.getOrderNumber() == order.getOrderNumber()-1){
            return order;
        }else{
            return null;
        }
    }

    @Override
    public Order updateOrder(Order order) {
        if(onlyOrder.getOrderNumber() == order.getOrderNumber()){
            return onlyOrder;
        }else{
            return null;
        }
    }

    @Override
    public Order removeOrder(Order order) {
        if(onlyOrder.getOrderNumber() == order.getOrderNumber()){
            return onlyOrder;
        }else{
            return null;
        }
    }

    @Override
    public Order getOrder(LocalDate date, int orderNumber) {
        if(onlyOrder.getOrderNumber() == orderNumber && onlyOrder.getDate().equals(date)){
            return onlyOrder;
        }else{
            return null;
        }
    }

    @Override
    public Map<LocalDate, Map<Integer, Order>> exportAllData() {
        Map<LocalDate, Map<Integer, Order>> ordersMap = new HashMap<>();
        Map<Integer, Order> innerMap = new HashMap<>();
        innerMap.put(onlyOrder.getOrderNumber(), onlyOrder);
        ordersMap.put(onlyOrder.getDate(), innerMap);
        return ordersMap;
    }

    @Override
    public List<Map<Integer, Order>> getOrderNumbers() throws OrderPersistenceException {
        List<Map<Integer, Order>> ordersMapList = new ArrayList<>();
        Map<Integer, Order> ordersMap = new HashMap<>();
        ordersMap.put(onlyOrder.getOrderNumber(), onlyOrder);
        ordersMapList.add(ordersMap);
        return ordersMapList;
    }

    @Override
    public List<LocalDate> orderDate() throws OrderPersistenceException {
       List<LocalDate> orderDate = new ArrayList<>();
       orderDate.add(onlyOrder.getDate());
       return orderDate;
    }
    
}
