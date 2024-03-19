package com.fiap.model;


import jakarta.persistence.*;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@Entity
public class Tarefa {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição da tarefa é obrigatória")
    private String descricao;
    
    @NotNull(message = "O prazo da tarefa é obrigatório")
    private LocalDate prazo;
 
    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
 
   
 
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
 
    public LocalDate getPrazo() {
        return prazo;
    }
 
    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
 
    public Materia getMateria() {
        return materia;
    }
 
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}