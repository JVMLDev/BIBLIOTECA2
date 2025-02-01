package com.projeto.Biblioteca.controller;

import com.projeto.Biblioteca.models.Livros;
import com.projeto.Biblioteca.service.LivrosService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aluno.lauro
 */
@RestController
@RequestMapping("/livros")
public class LivrosController {
     private final LivrosService livrosService; 
    
    public LivrosController(LivrosService livrosService){
        this.livrosService = livrosService;
    }
    
    @GetMapping
    public List<Livros> listarTodos(){
        return this.livrosService.listarTodos();
    }
    
    
    @PostMapping
    public Livros inserir(@RequestParam String nome, @RequestParam String autor){
        return this.livrosService.inserir(nome, autor);
    } 
    
    @PutMapping("/{id}")
    public Livros atualizar(@PathVariable int id, @RequestParam String nome, @RequestParam String autor){
        return this.livrosService.atualizar(id, nome, autor);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        this.livrosService.deletar(id);
        System.out.println("Livro deletado com sucesso!");
    }
}