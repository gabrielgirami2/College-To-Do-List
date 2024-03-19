package com.fiap.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;
 
@Service
public class TarefaService {
 
    @Autowired
    private TarefaRepository tarefaRepository;
 
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }
 
    public Tarefa adicionarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }
 
    public void apagarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
 
    public Optional<Tarefa> detalharTarefa(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }
 
    public Tarefa atualizarTarefa(Long id, Tarefa tarefa) {
        if (tarefaRepository.existsById(id)) {
            tarefa.setId(id);
            return tarefaRepository.save(tarefa);
        } else {
            return null;
        }
    }
}
