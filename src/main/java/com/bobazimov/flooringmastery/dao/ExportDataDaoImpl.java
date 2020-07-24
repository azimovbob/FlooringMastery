/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.dao;

import com.bobazimov.flooringmastery.model.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;


public class ExportDataDaoImpl implements ExportDataDao {
    
    final private String BACKUP_FILE_PATH; 
    final private String DELIMITER = ",";
    private Map<LocalDate, Map<Integer, Order>> outerMap;

    public ExportDataDaoImpl() {
        BACKUP_FILE_PATH = "Backup/DataExport.txt"; 
    }

    
    public ExportDataDaoImpl(String BACKUP_FILE_PATH) {
        this.BACKUP_FILE_PATH = BACKUP_FILE_PATH;
    }
    
    @Override
    public void getAllData(Map<LocalDate, Map<Integer, Order>> allOrders) throws OrderPersistenceException{
        outerMap = allOrders;
        writeAllData();
    }

    @Override
    public void deleteOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String marshalling(Order order){
        String date = order.getDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String orderAsText = order.getOrderNumber() + DELIMITER + order.getCustomerName() + DELIMITER + order.getState().getStateAbbrivation() +
                             DELIMITER + order.getState().getTaxRate() + DELIMITER + order.getProduct().getProductType() + DELIMITER +
                             order.getArea() + DELIMITER + order.getProduct().getCostPerSqFt() + DELIMITER + order.getProduct().getCostPerSqFt() +
                             DELIMITER + order.getTotalProductCost() + DELIMITER + order.getTotalLaborCost() + DELIMITER + order.getTotal() + 
                             DELIMITER + date;
        return orderAsText;
    }
    //OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total,OrderDate
    private void writeAllData() throws OrderPersistenceException{
        String orderStr;
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(BACKUP_FILE_PATH));
        }catch(IOException ex){
            throw new OrderPersistenceException("Could not save data to the file");
        }
        out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");

        for(Map.Entry<LocalDate, Map<Integer, Order>> currentMap: outerMap.entrySet()){
            for(Map.Entry<Integer, Order> currentOrder: currentMap.getValue().entrySet()){
                orderStr = marshalling(currentOrder.getValue());
                out.println(orderStr);
                out.flush();
            }
        }
        out.close();
    }
}
