package com.sv.cursosApp.service;

import java.util.List;
import com.sv.cursosApp.model.Categoria;

public interface ICategoriaService {

    List<Categoria> buscarTodos();

    Categoria buscarPorId(Integer id);

    void guardar(Categoria categoria);

    void eliminar(Integer id);
}