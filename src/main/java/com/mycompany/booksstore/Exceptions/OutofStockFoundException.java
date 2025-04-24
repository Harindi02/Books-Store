/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ASUS OLED
 */
    

package com.mycompany.booksstore.Exceptions;

public class OutofStockFoundException extends RuntimeException {
    public OutofStockFoundException(String message) {
        super(message);
    }
}