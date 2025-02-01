/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.service;

import com.projeto.Biblioteca.excepitionhandler.CamposObrigatoriosException;
import com.projeto.Biblioteca.excepitionhandler.IdNotFoundException;
import com.projeto.Biblioteca.models.Livros;
import com.projeto.Biblioteca.repository.LivrosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aluno.lauro
 */
@Service
public class LivrosService {
     private final LivrosRepository livrosRepository;

    public LivrosService(LivrosRepository livrosRepository){
        this.livrosRepository = livrosRepository;
    }
    
    public List<Livros> listarTodos(){
        return this.livrosRepository.findAll();
    }
    
    public Livros inserir(String nome, String autor){
        if(nome.isBlank() || autor.isBlank()){
            System.out.println("Lançando CamposObrigatoriosException: Nome -> " + nome + ", Autor -> " + autor);
             throw new CamposObrigatoriosException(); 
        }
        Livros l = new Livros();
        l.setNome(nome);
        l.setAutor(autor);
        return this.livrosRepository.save(l);
    }
    
    public Livros atualizar(int id,String nome,String autor){
         if(nome.isBlank() || autor.isBlank()){
            System.out.println("Lançando CamposObrigatoriosException: Nome -> " + nome + ", Autor -> " + autor);
             throw new CamposObrigatoriosException(); 
        }
        Livros livro = this.livrosRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
        livro.setNome(nome);
        livro.setAutor(autor);
        return this.livrosRepository.save(livro);
    }
    
    public void deletar(int id){
        Optional<Livros> livro = livrosRepository.findById(id);
        if(livro.isEmpty()){
            throw new IdNotFoundException();
        }
        this.livrosRepository.deleteById(id);
    }
}