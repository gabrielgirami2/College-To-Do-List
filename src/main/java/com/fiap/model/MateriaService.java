package com.fiap.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.repository.MateriaRepository;



@Service
public class MateriaService {
    
    @Autowired
    private MateriaRepository materiaRepository;
 
    public List<Materia> listarMaterias() {
        return materiaRepository.findAll();
    }
 
    public Materia adicionarMateria(Materia materia) {
        return materiaRepository.save(materia);
    }
 
    public void apagarMateria(Long id) {
        materiaRepository.deleteById(id);
    }
 
    public Materia detalharMateria(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }
 
    public Materia atualizarMateria(Long id, Materia materia) {
        if (materiaRepository.existsById(id)) {
            materia.setId(id);
            return materiaRepository.save(materia);
        } else {
            return null;
        }
    }
}
