/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.ExportDataDao;
import com.bobazimov.flooringmastery.dao.OrderDao;
import com.bobazimov.flooringmastery.dao.OrderPersistenceException;
import com.bobazimov.flooringmastery.dao.ProductDao;
import com.bobazimov.flooringmastery.dao.StateDao;
import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OrderServiceImpl implements OrderService {

    OrderDao orderDao;
    ProductDao productDao;
    StateDao stateDao;
    ExportDataDao exportDao;
    
    public OrderServiceImpl(OrderDao orderDao, ProductDao productDao, StateDao stateDao, ExportDataDao exportDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.stateDao = stateDao;
        this.exportDao = exportDao;
    }
    
    private int generateOrderNumber() throws OrderPersistenceException{
        int max = 0;
        for(Map<Integer, Order> currentOrder: orderDao.getOrderNumbers()){
            for(int currentNumber: currentOrder.keySet()){
                if(currentNumber > max){
                    max = currentNumber;
                }
            }   
            
        }
        return max+1;
    }
     
    @Override
    public Order createAndCalculateTotal(Order order) throws OrderPersistenceException, ValidateStateAndProductException, OrderDataValidationException {
        validateOrderData(order);
        BigDecimal percentage = new BigDecimal("100");
        BigDecimal materialCost = order.getArea().multiply(order.getProduct().getCostPerSqFt());
        BigDecimal laborCost = order.getArea().multiply(order.getProduct().getLaborCostPerSqft());
        BigDecimal tax = materialCost.add(laborCost).multiply(order.getState().getTaxRate().divide(percentage));
        BigDecimal total = materialCost.add(laborCost).add(tax);
        
        Order updatingOrder = order;
        updatingOrder.setTotalProductCost(materialCost.setScale(2, RoundingMode.DOWN));
        updatingOrder.setTotalLaborCost(laborCost.setScale(2, RoundingMode.DOWN));
        updatingOrder.setTotalTax(tax.setScale(2, RoundingMode.DOWN));
        updatingOrder.setTotal(total.setScale(2, RoundingMode.DOWN));
        
        return updatingOrder;
    }
    
    @Override
    public Order addOrder(Order order) throws OrderPersistenceException {
        
        Order newOrder = order;
        int orderNumber = generateOrderNumber();
        newOrder.setOrderNumber(orderNumber);
        return orderDao.addOrder(newOrder);
        
    }
    
    @Override
    public void removeOrder(Order order) throws OrderPersistenceException{
        orderDao.removeOrder(order);
    }

    @Override
    public Order updateOrder(Order order) throws OrderPersistenceException {
        return orderDao.updateOrder(order);
    }

    @Override
    public List<Order> getOrders(LocalDate date) throws OrderPersistenceException, OrderValidationException{
        validateOrderDate(date);
        return orderDao.getOrders(date);
    }

    @Override
    public Order getOrder(LocalDate date, int orderNumber) throws OrderPersistenceException, OrderValidationException{
        validateOrderDate(date);
        validateOrderNumber(date, orderNumber);
        return orderDao.getOrder(date, orderNumber);
    }

    @Override
    public List<Product> getProducts() throws OrderPersistenceException{
        return new ArrayList<>(productDao.getProducts().values());
    }

    @Override
    public Product getProduct(String productType) throws OrderPersistenceException, ValidateStateAndProductException{
        validateProduct(productType);
        return productDao.getProduct(productType);
    }

    @Override
    public List<State> getStates() throws OrderPersistenceException{
        return new ArrayList<>(stateDao.getStates().values());
    }

    @Override
    public State getState(String stateName) throws OrderPersistenceException, ValidateStateAndProductException{
        validateState(stateName);
        return stateDao.getState(stateName);
    }

    @Override
    public void exportAllData(Map<LocalDate, Map<Integer, Order>> allOrders) throws OrderPersistenceException{
        exportDao.getAllData(allOrders);
    }
    
    private void validateOrderNumber(LocalDate date, int orderNumber) throws OrderPersistenceException, OrderValidationException{
        if(!orderDao.exportAllData().get(date).keySet().contains(orderNumber)){
            throw new OrderValidationException("No such order with given number");
        }
    }
    
    private void validateOrderDate(LocalDate date)throws OrderPersistenceException, OrderValidationException{
        if(!orderDao.orderDate().contains(date)){
            throw new OrderValidationException("EROOR: Orders with given date do not exist");
        }
    }

    private void validateOrderData(Order order) throws OrderDataValidationException{
        if(order.getDate() == null || order.getCustomerName() == null ||
           order.getArea() == null || order.getProduct().getProductType() == null ||
           order.getState().getStateAbbrivation() == null){
           throw new OrderDataValidationException("ERROR: Al fields[Customer Name, Date, State, ProductType, Area] required");
           
    }
        
    }

    @Override
    public Map<LocalDate, Map<Integer, Order>> getAllOrders() throws OrderPersistenceException {
        return orderDao.exportAllData();
    }
    
    private void validateState(String state) throws OrderPersistenceException, ValidateStateAndProductException{
        if(!stateDao.getStates().containsKey(state)){
            throw new ValidateStateAndProductException("ERROR: Wrong state, please enter different state");
        }
    }
     
    private void validateProduct(String productType) throws OrderPersistenceException, ValidateStateAndProductException{
        if(!productDao.getProducts().containsKey(productType)){
            throw new ValidateStateAndProductException("ERROR: Wrong product");
        }
    }
    
    
}
