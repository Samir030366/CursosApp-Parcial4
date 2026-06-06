package com.sv.cursosApp.service;

import java.util.List;
import com.sv.cursosApp.model.Curso;

public interface ICursoService {

    List<Curso> buscarTodos();

    Curso buscarPorId(Integer id);

    void guardar(Curso curso);

    void eliminar(Integer id);
}