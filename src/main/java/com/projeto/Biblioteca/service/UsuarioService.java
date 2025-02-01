/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.service;
import com.projeto.Biblioteca.excepitionhandler.CamposObrigatoriosException;
import com.projeto.Biblioteca.excepitionhandler.IdNotFoundException;
import com.projeto.Biblioteca.models.Usuario;
import com.projeto.Biblioteca.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aluno.lauro
 */
@Service
public class UsuarioService {
 
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    
    public List<Usuario> listarTodos(){
        return this.usuarioRepository.findAll();
    }
    
    public Usuario inserir(String nome, String email){
        if( nome.isBlank() ||  email.isBlank()){
            System.out.println("Lançando CamposObrigatoriosException: Nome -> " + nome + ", Email -> " + email);
            throw new CamposObrigatoriosException(); 
        }
            Usuario u = new Usuario();
            u.setNome(nome);
            u.setEmail(email);
            return this.usuarioRepository.save(u);
    }
    
    public Usuario atualizar(Long id,String nome,String email){
        if( nome.isBlank() ||  email.isBlank()){
            System.out.println("Lançando CamposObrigatoriosException: Nome -> " + nome + ", Email -> " + email);
            throw new CamposObrigatoriosException(); 
        }
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
        usuario.setNome(nome);
        usuario.setEmail(email);
        return this.usuarioRepository.save(usuario);
    }
    
    public void deletar(Long id){
        //está buscando um usuário no banco de dados pelo id e armazenando o resultado dentro de um Optional<Usuario>
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new IdNotFoundException();
        }
        this.usuarioRepository.deleteById(id);
    }
}
