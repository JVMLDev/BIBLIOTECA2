/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.controller;

import com.projeto.Biblioteca.models.Emprestimo;
import com.projeto.Biblioteca.service.EmprestimoService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aluno.lauro
 */
@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    
    private final EmprestimoService emprestimoService; 
    
    public EmprestimoController(EmprestimoService emprestimoService){
        this.emprestimoService = emprestimoService;
    }
    
    @GetMapping
    public List<Emprestimo> listarTodos(){
        return this.emprestimoService.listarTodosEmprestimos();
    }
    
    
    @PostMapping
    public Emprestimo inserir(@RequestParam String id_usuario, @RequestParam String id_livro){
        return this.emprestimoService.inserir(id_usuario, id_livro);
    } 
    
    @PutMapping("/{id}")
    public Emprestimo atualizar(@PathVariable int id){
        return this.emprestimoService.atualizar(id);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        this.emprestimoService.deletar(id);
    }
            
}
