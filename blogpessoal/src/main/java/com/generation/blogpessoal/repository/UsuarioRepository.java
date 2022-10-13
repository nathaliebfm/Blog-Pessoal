package com.generation.blogpessoal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ //JPA faz relação com o banco de dados
    
    public Optional<Usuario> findByUsuario(String usuario); //Usa o optional, pois não queremos a lista de usuários, e sim um específico

}
