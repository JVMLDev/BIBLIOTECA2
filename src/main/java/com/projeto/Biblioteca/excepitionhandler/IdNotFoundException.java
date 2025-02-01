/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.excepitionhandler;

/**
 *
 * @author TainaSilva
 */
public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException() {
        super("Id não encontrado");
    }
    
    public IdNotFoundException(String message) {
        super(message);
    };
   
}
