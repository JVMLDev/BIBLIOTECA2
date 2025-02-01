/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.repository;

import com.projeto.Biblioteca.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author aluno.lauro
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}