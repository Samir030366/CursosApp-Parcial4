package com.sv.cursosApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sv.cursosApp.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}