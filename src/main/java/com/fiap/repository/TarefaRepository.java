package com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.model.Tarefa;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}