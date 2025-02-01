/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.excepitionhandler;

/**
 *
 * @author aluno.lauro
 */
public class CamposObrigatoriosException extends RuntimeException {
    public CamposObrigatoriosException() {
        super("Preenchimento dos compos é obrigatório.");
    }

    public CamposObrigatoriosException(String message) {
        super(message);
    }

    String getParameterName() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
