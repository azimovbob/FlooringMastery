/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
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
public class OrderDaoImplTest {

    OrderDao dao;

    public OrderDaoImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        dao = new OrderDaoImpl("OrdersTest/");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetOrder() throws OrderPersistenceException {

        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Doctor Who");
        State state = new State();
        state.setStateAbbrivation("WA");
        BigDecimal taxRate = new BigDecimal("9.25");
        state.setTaxRate(taxRate);
        Product product = new Product();
        product.setProductType("Wood");
        BigDecimal area = new BigDecimal("243.00");
        order.setArea(area);
        BigDecimal costPerSqFt = new BigDecimal("5.15");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.75");
        product.setCostPerSqFt(costPerSqFt);
        product.setLaborCostPerSqft(laborCostPerSqFt);
        order.setProduct(product);
        order.setState(state);
        BigDecimal materialCost = new BigDecimal("1251.45");
        BigDecimal laborCost = new BigDecimal("1154.25");
        BigDecimal tax = new BigDecimal("216.51");
        BigDecimal total = new BigDecimal("2622.21");
        order.setTotalProductCost(materialCost);
        order.setTotalLaborCost(laborCost);
        order.setTotalTax(tax);
        order.setTotal(total);
        order.setDate(ld);
        Order testOrder = dao.getOrder(ld, orderNumber);

        assertNotNull(testOrder, "it must be not null");
        assertEquals(testOrder, order, "Objects must be an eqaul");

    }

    @Test
    public void testGetOrdersByDate() throws OrderPersistenceException {
        String date = "06012013";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate ld = LocalDate.parse(date, df);
        List<Order> testOrder = dao.getOrders(ld);

        assertNotNull(testOrder, "Map must not be null");
        
    }
    
    @Test
    public void testExportAllData() throws OrderPersistenceException{
        
        Map<LocalDate, Map<Integer, Order>> testMap = dao.exportAllData();
        
        assertNotNull(testMap, "Map shouldn't be null");
        
    }
    
    @Test
    public void testAddOrder() throws OrderPersistenceException{
        
        String date = "04012017";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate ld = LocalDate.parse(date, df);
        int orderNumber = 9;

        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setCustomerName("Doctor Me");
        State state = new State();
        state.setStateAbbrivation("WA");
        BigDecimal taxRate = new BigDecimal("9.25");
        state.setTaxRate(taxRate);
        Product product = new Product();
        product.setProductType("Wood");
        BigDecimal area = new BigDecimal("243.00");
        order.setArea(area);
        BigDecimal costPerSqFt = new BigDecimal("5.15");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.75");
        product.setCostPerSqFt(costPerSqFt);
        product.setLaborCostPerSqft(laborCostPerSqFt);
        order.setProduct(product);
        order.setState(state);
        BigDecimal materialCost = new BigDecimal("1251.45");
        BigDecimal laborCost = new BigDecimal("1154.25");
        BigDecimal tax = new BigDecimal("216.51");
        BigDecimal total = new BigDecimal("2622.21");
        order.setTotalProductCost(materialCost);
        order.setTotalLaborCost(laborCost);
        order.setTotalTax(tax);
        order.setTotal(total);
        order.setDate(ld);
        
        Order testOrder = dao.addOrder(order);
        
        assertNotNull(testOrder, "It should be not null");
    }
    
    @Test
    public void testGetRemoveOrder()throws OrderPersistenceException{
        String date = "04012016";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate ld = LocalDate.parse(date, df);
        int orderNumber = 5;

        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setCustomerName("Doctor Me");
        State state = new State();
        state.setStateAbbrivation("WA");
        BigDecimal taxRate = new BigDecimal("9.25");
        state.setTaxRate(taxRate);
        Product product = new Product();
        product.setProductType("Wood");
        BigDecimal area = new BigDecimal("243.00");
        order.setArea(area);
        BigDecimal costPerSqFt = new BigDecimal("5.15");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.75");
        product.setCostPerSqFt(costPerSqFt);
        product.setLaborCostPerSqft(laborCostPerSqFt);
        order.setProduct(product);
        order.setState(state);
        BigDecimal materialCost = new BigDecimal("1251.45");
        BigDecimal laborCost = new BigDecimal("1154.25");
        BigDecimal tax = new BigDecimal("216.51");
        BigDecimal total = new BigDecimal("2622.21");
        order.setTotalProductCost(materialCost);
        order.setTotalLaborCost(laborCost);
        order.setTotalTax(tax);
        order.setTotal(total);
        order.setDate(ld);
        
        Order testOrder = dao.addOrder(order);
        String testDate = "04012016";
        LocalDate testLd = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int testOrderNumber = 5;
        Order testOrder1 = dao.getOrder(testLd, testOrderNumber);
        Order testRemovedOrder = dao.removeOrder(testOrder1);
        
        assertNotNull(testRemovedOrder, "Removed order must be not null");
        
    }
    
   @Test
   public void update() throws OrderPersistenceException{
       
        String date = "04012017";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate ld = LocalDate.parse(date, df);
        int orderNumber = 9;

        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setCustomerName("Doctor Us");
        State state = new State();
        state.setStateAbbrivation("TX");
        BigDecimal taxRate = new BigDecimal("9.25");
        state.setTaxRate(taxRate);
        Product product = new Product();
        product.setProductType("Tile");
        BigDecimal area = new BigDecimal("200.00");
        order.setArea(area);
        BigDecimal costPerSqFt = new BigDecimal("5.15");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.75");
        product.setCostPerSqFt(costPerSqFt);
        product.setLaborCostPerSqft(laborCostPerSqFt);
        order.setProduct(product);
        order.setState(state);
        BigDecimal materialCost = new BigDecimal("1251.45");
        BigDecimal laborCost = new BigDecimal("1154.25");
        BigDecimal tax = new BigDecimal("216.51");
        BigDecimal total = new BigDecimal("2622.21");
        order.setTotalProductCost(materialCost);
        order.setTotalLaborCost(laborCost);
        order.setTotalTax(tax);
        order.setTotal(total);
        order.setDate(ld);
        Order getOrder = dao.getOrder(order.getDate(), orderNumber);
        Order testOrder = dao.updateOrder(order);
        
        assertEquals(testOrder, order, "This two must be eqaul");
   }

}
