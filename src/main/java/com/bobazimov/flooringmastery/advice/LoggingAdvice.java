/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.advice;

import com.bobazimov.flooringmastery.dao.AuditDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author irabob
 */
public class LoggingAdvice {
    
    AuditDao dao;
    
    public LoggingAdvice(AuditDao dao){
        this.dao = dao;
    }
    
    public void createAuditEntry(JoinPoint jp){
        
        Object[] objects = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        
        for(Object currentArgs: objects){
            auditEntry+=currentArgs;
        }
        try{
            dao.writeAuditEntry(auditEntry);
        }catch(Exception ex){
            System.err.println("Error: Could not creat auditEntry");
        }
    }
    
    public void createExceptionEntry(Exception ex){
        String exception = ex.getMessage();
        
        try{
            dao.writeAuditEntry(exception);
        }catch(Exception e){
            System.err.println("ERROR: Could not create audit entry");
        }
    }
}
