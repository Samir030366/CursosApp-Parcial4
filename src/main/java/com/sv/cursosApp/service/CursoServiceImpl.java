package com.sv.cursosApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.cursosApp.model.Curso;
import com.sv.cursosApp.repository.ICursoRepository;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepository;

    @Override
    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso buscarPorId(Integer id) {
        Optional<Curso> optional = cursoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void guardar(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void eliminar(Integer id) {
        cursoRepository.deleteById(id);
    }
}