package com.fiap.controller;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.fiap.model.Materia;
import com.fiap.model.MateriaService;

import java.util.Optional;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public ResponseEntity<Class<? extends Page>> listarMaterias(
            @RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "10") Integer tamanho) {
        Page materias = materiaService.listarMateriasPaginadas(PageRequest.of(pagina, tamanho));
        return ResponseEntity.ok(materias.getClass());
    }

    @PostMapping
    public ResponseEntity<Materia> adicionarMateria(@RequestBody Materia materia) {
        Materia novaMateria = materiaService.adicionarMateria(materia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMateria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarMateria(@PathVariable Long id) {
        materiaService.apagarMateria(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalharMateria(@PathVariable Long id) {
        Optional<Materia> materiaOptional = materiaService.detalharMateria(id);
        return materiaOptional.map(materia -> ResponseEntity.ok(materia))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> atualizarMateria(@PathVariable Long id, @RequestBody Materia materia) {
        Materia materiaAtualizada = materiaService.atualizarMateria(id, materia);
        return materiaAtualizada != null ? ResponseEntity.ok(materiaAtualizada) : ResponseEntity.notFound().build();
    }
}



