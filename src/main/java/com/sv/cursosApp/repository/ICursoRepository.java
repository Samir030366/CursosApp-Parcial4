package com.sv.cursosApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sv.cursosApp.model.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {

}