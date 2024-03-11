package com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.model.Materia;
import com.fiap.model.MateriaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
@RestController
@RequestMapping("/materias")
public class MateriaController {
 
    @Autowired
    private MateriaService materiaService;
 
    @GetMapping
    public ResponseEntity<?> listarMaterias(@PathVariable Long id) {
        List<Materia> materias = materiaService.listarMaterias();
        return new ResponseEntity<>(materias, HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Materia> adicionarMateria(@RequestBody Materia materia) {
        Materia novaMateria = materiaService.adicionarMateria(materia);
        return new ResponseEntity<>(novaMateria, HttpStatus.CREATED);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarMateria(@PathVariable Long id) {
        materiaService.apagarMateria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<?> detalharMateria(@PathVariable Long id) {
        Materia materia = materiaService.detalharMateria(id);
        if (materia != null) {
            return new ResponseEntity<>(materia, HttpStatus.OK);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("mensagem", "Matéria não encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Materia> atualizarMateria(@PathVariable Long id, @RequestBody Materia materia) {
        Materia materiaAtualizada = materiaService.atualizarMateria(id, materia);
        if (materiaAtualizada != null) {
            return new ResponseEntity<>(materiaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

