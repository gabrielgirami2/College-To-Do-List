package com.fiap.model;


import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
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