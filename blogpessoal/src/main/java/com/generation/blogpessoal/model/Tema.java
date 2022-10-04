package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_temas")
public class Tema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String descricao;
    
    //mappedBy e cascade: Todas as postagens que forem relacionadas a um tema, se ele for excluído, elas também serão
    @OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("tema")
    private List<Postagem> postagem; //faz a lista de postagens de cada tema

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

}
