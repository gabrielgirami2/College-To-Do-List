package com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.model.Tarefa;
import com.fiap.model.TarefaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
@RestController
@RequestMapping("/tarefas")
public class TarefaController {
 
    @Autowired
    private TarefaService tarefaService;
 
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Tarefa> adicionarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.adicionarTarefa(tarefa);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarTarefa(@PathVariable Long id) {
        tarefaService.apagarTarefa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<?> detalharTarefa(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.detalharTarefa(id);
        if (tarefa != null) {
            return new ResponseEntity<>(tarefa, HttpStatus.OK);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("mensagem", "Tarefa não encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa);
        if (tarefaAtualizada != null) {
            return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}