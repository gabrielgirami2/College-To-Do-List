package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

 
@Entity
public class Materia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da matéria é obrigatório")
    @Size(min = 2, message = "O nome da matéria deve ter pelo menos 2 caracteres")
    private String nome;
    
    @NotBlank(message = "O nome do professor é obrigatório")
    private String professor;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getProfessor() {
        return professor;
    }
 
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Object map(Object object) {
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }
}

