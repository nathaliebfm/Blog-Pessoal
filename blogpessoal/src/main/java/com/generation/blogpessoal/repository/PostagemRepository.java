package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    
    //É uma regra específica para o negócio, não é um padrão como no controller, então precisa criar primeiro aqui para usar lá
    public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo); //Usa param para encontrar a partir de uma parte do título, começou a digitar, ele já encontra

}
