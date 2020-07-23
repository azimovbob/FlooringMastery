/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

import com.bobazimov.flooringmastery.dao.OrderPersistenceException;
import com.bobazimov.flooringmastery.model.Order;
import com.bobazimov.flooringmastery.model.Product;
import com.bobazimov.flooringmastery.model.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author irabob
 */
public class OrderServiceImplTest {

    OrderServiceImpl service;

    public OrderServiceImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceTest", OrderServiceImpl.class);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetValidOrder() throws OrderPersistenceException, OrderValidationException {
        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        Order onlyOrder = new Order();
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

        try {
            service.getOrder(ld, orderNumber);
        } catch (OrderValidationException ex) {
            fail("Order was valid. No exception should be thrown");
        }
    }

    @Test
    public void testGetOrderWithIvalidDate() throws OrderPersistenceException, OrderValidationException {
        String date = "06012015";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        Order onlyOrder = new Order();
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

        try {
            service.getOrder(ld, orderNumber);
            fail("Exception validation was not thrown");
        } catch (OrderValidationException ex) {
            return;
        }
    }

    @Test
    public void testGetOrderWithInvalidOrderNumber() throws OrderPersistenceException, OrderValidationException {
        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 33;

        Order onlyOrder = new Order();
        onlyOrder.setOrderNumber(orderNumber);
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

        try {
            service.getOrder(ld, onlyOrder.getOrderNumber());
            fail("Exception validation was not thrown");
        } catch (OrderValidationException ex) {
            return;
        }
        fail("Wrong exception was thrown");
    }

    @Test
    public void testAddOrder() throws OrderPersistenceException {
        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        Order onlyOrder = new Order();
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

        Order addedOrder = service.addOrder(onlyOrder);

        assertNotNull(addedOrder, "It should not be null");
        assertEquals(addedOrder, onlyOrder, "Both orders must be equal");
    }

    @Test
    public void createAndCalculateOrder() throws OrderPersistenceException, ValidateStateAndProductException,
            OrderDataValidationException, OrderValidationException {
        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        Order onlyOrder = new Order();
        onlyOrder.setOrderNumber(orderNumber);
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
        onlyOrder.setDate(ld);

        Order calculatedOrder = service.createAndCalculateTotal(onlyOrder);
        Order testOrder = service.getOrder(onlyOrder.getDate(), onlyOrder.getOrderNumber());

        assertNotNull(calculatedOrder, "It must not be null");
        assertEquals(calculatedOrder, testOrder, "Orders must be equal");
    }

    @Test
    public void getOrdersByDate() throws OrderValidationException, OrderPersistenceException {

        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        List<Order> testOrderList;

        testOrderList = service.getOrders(ld);

        assertFalse(testOrderList.isEmpty());
    }

    @Test
    public void testRemoveOrder() throws OrderPersistenceException, OrderValidationException {
        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        Order onlyOrder = new Order();
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

        Order orderWho = service.getOrder(onlyOrder.getDate(), onlyOrder.getOrderNumber());

        assertNotNull(orderWho, "Getting order with number 2 should be not null");
        assertEquals(orderWho, onlyOrder, "Orders must be equal");
    }

    @Test
    public void testUpdateOrder() throws OrderPersistenceException {

        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        Order onlyOrder = new Order();
        onlyOrder.setCustomerName("Doctor Who");
        onlyOrder.setOrderNumber(orderNumber);
        State state = new State();
        state.setStateAbbrivation("WA");
        BigDecimal taxRate = new BigDecimal("9.25");
        state.setTaxRate(taxRate);
        Product product = new Product();
        product.setProductType("Carpet");
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

        Order updatedOrder = service.updateOrder(onlyOrder);

        assertNotNull(updatedOrder, "It's null");
        assertNotEquals(updatedOrder, onlyOrder);

    }
    
    @Test
    public void testExportData() throws OrderPersistenceException{
        
        String date = "06012013";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;

        Order onlyOrder = new Order();
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
        
        assertNotNull(service.getAllOrders());
    }
}

//<Order{orderNumber=2, customerName=Doctor Who, state=State{state=null, stateAbbrivation=WA, taxRate=9.25}, product=Product{productType=Wood, costPerSqFt=5.15, laborCostPerSqft=4.75}, area=243.00, totalLaborCost=1154.2500, totalProductCost=1251.4500, totalTax=222.52725000, total=2628.22725000, date=2013-06-01}> 
//<Order{orderNumber=2, customerName=Doctor Who, state=State{state=null, stateAbbrivation=WA, taxRate=9.25}, product=Product{productType=Wood, costPerSqFt=5.15, laborCostPerSqft=4.75}, area=243.00, totalLaborCost=1154.25, totalProductCost=1251.45, totalTax=216.51, total=2622.21, date=2013-06-01}
