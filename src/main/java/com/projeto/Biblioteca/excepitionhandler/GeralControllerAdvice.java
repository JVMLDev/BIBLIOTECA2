/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.excepitionhandler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author TainaSilva
 */
@ControllerAdvice()
public class GeralControllerAdvice {
    @ResponseBody
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> idNotFound(IdNotFoundException idNotFound){
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(),"Id não encontrado");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @ResponseBody
    @ExceptionHandler(CamposObrigatoriosException.class)
    public ResponseEntity<MessageExceptionHandler> camposObrigatoriosHandler(CamposObrigatoriosException ex) {
        System.out.println("Exceção lançada: " + ex.getMessage());
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), "Preenchimento dos compos é obrigatório.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    } 
    
    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<MessageExceptionHandler> handleMissingParams(MissingServletRequestParameterException ex) {
    String paramName = ex.getParameterName();
    MessageExceptionHandler error = new MessageExceptionHandler(
            new Date(),
            HttpStatus.BAD_REQUEST.value(),
            "O parâmetro obrigatório '" + paramName + "' está ausente.");
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
  
}
