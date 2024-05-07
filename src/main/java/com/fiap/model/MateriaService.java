package com.fiap.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public Optional<Materia> detalharMateria(Long id) {
        return materiaRepository.findById(id);
    }

    public Materia atualizarMateria(Long id, Materia materia) {
        if (materiaRepository.existsById(id)) {
            materia.setId(id);
            return materiaRepository.save(materia);
        } else {
            return null;
        }
    }

    public Page listarMateriasPaginadas(PageRequest pageRequest) {
        return (Page) materiaRepository.findAll(pageRequest);
    }
}

