/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.flooringmastery.service;

/**
 *
 * @author irabob
 */
public class ValidateStateAndProductException extends Exception {

    public ValidateStateAndProductException(String message) {
        super(message);
    }

    public ValidateStateAndProductException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
