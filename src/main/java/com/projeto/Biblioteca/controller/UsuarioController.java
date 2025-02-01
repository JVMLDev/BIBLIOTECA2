/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.controller;
import com.projeto.Biblioteca.models.Usuario;
import com.projeto.Biblioteca.service.UsuarioService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aluno.lauro
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
     private final UsuarioService usuarioService; 
    
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @GetMapping
    public List<Usuario> listarTodos(){
        return this.usuarioService.listarTodos();
    }
    
    @PostMapping
    public Usuario inserir(@RequestParam String nome, @RequestParam String email){
        return this.usuarioService.inserir(nome, email);
    } 
    
   @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestParam String nome, @RequestParam String email){
        return this.usuarioService.atualizar(id, nome, email);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.usuarioService.deletar(id);
    }
}
