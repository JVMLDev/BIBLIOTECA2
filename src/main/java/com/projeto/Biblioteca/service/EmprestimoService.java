/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.service;

import com.projeto.Biblioteca.excepitionhandler.CamposObrigatoriosException;
import com.projeto.Biblioteca.excepitionhandler.IdNotFoundException;
import com.projeto.Biblioteca.models.Emprestimo;
import com.projeto.Biblioteca.repository.EmprestimoRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aluno.lauro
 */
@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    
    public EmprestimoService(EmprestimoRepository emprestimoRepository){
        this.emprestimoRepository = emprestimoRepository;
    }
    
    public List<Emprestimo> listarTodosEmprestimos(){
        return this.emprestimoRepository.findAll();
    }
    
    public Emprestimo inserir (String id_usuario, String id_livro){
        LocalDate data_emprestimo = LocalDate.now();
        if (id_usuario.isBlank() || id_livro.isBlank()) {
           System.out.println("Lançando CamposObrigatoriosException: Usuario -> " + id_usuario + ", Livro -> " + id_livro);
            throw new CamposObrigatoriosException(); 
        }
        Emprestimo ep = new Emprestimo();
        ep.setId_usuario(id_usuario);
        ep.setId_livro(id_livro);
        ep.setData_emprestimo(data_emprestimo);
        ep.setData_devolucao(data_emprestimo.plusDays(15));
        return this.emprestimoRepository.save(ep);  
    }
    
    public Emprestimo atualizar(int id){
        Emprestimo emp = this.emprestimoRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
        emp.setData_devolucao(emp.getData_devolucao().plusDays(15));
        return this.emprestimoRepository.save(emp);
    }
    
    public void deletar(int id){
        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
        if(emprestimo.isEmpty()){
            throw new IdNotFoundException();
        }
        this.emprestimoRepository.deleteById(id);
    }
    
}
