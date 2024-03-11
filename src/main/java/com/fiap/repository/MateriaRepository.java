package com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.model.Materia;




@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
}
